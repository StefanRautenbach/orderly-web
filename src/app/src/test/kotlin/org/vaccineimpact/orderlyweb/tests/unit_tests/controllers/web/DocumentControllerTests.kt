package org.vaccineimpact.orderlyweb.tests.unit_tests.controllers.web

import com.nhaarman.mockito_kotlin.*
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.After
import org.junit.Test
import org.mockito.internal.verification.Times
import org.vaccineimpact.orderlyweb.ActionContext
import org.vaccineimpact.orderlyweb.Files
import org.vaccineimpact.orderlyweb.controllers.web.DocumentController
import org.vaccineimpact.orderlyweb.db.AppConfig
import org.vaccineimpact.orderlyweb.db.DocumentRepository
import org.vaccineimpact.orderlyweb.errors.MissingParameterError
import org.vaccineimpact.orderlyweb.errors.OrderlyFileNotFoundError
import org.vaccineimpact.orderlyweb.models.Document
import org.vaccineimpact.orderlyweb.tests.unit_tests.controllers.api.ControllerTest
import org.vaccineimpact.orderlyweb.viewmodels.Breadcrumb
import org.vaccineimpact.orderlyweb.viewmodels.IndexViewModel
import java.io.File

class DocumentControllerTests : ControllerTest()
{
    @After
    fun cleanup()
    {
        File("documents").deleteRecursively()
    }

    @Test
    fun `can get document`()
    {
        File("documents/some/path").mkdirs()
        File("documents/some/path/file.csv").createNewFile()

        val mockContext = mock<ActionContext>() {
            on { splat() } doReturn arrayOf("some", "path", "file.csv")
            on { this.getSparkResponse() } doReturn mockSparkResponse
        }

        val sut = DocumentController(mockContext, AppConfig(), Files(), mock())
        sut.getDocument()
        verify(mockContext)
                .addResponseHeader("Content-Disposition", "attachment; filename=\"some/path/file.csv\"")
        verify(mockContext).addDefaultResponseHeaders("text/csv")
    }

    @Test
    fun `attachment header is not added for inline documents`()
    {
        File("documents/some/path").mkdirs()
        File("documents/some/path/file.csv").createNewFile()

        val mockContext = mock<ActionContext>() {
            on { splat() } doReturn arrayOf("some", "path", "file.csv")
            on { queryParams("inline") } doReturn "true"
            on { this.getSparkResponse() } doReturn mockSparkResponse
        }

        val sut = DocumentController(mockContext, AppConfig(), Files(), mock())
        sut.getDocument()
        verify(mockContext, Times(0))
                .addResponseHeader(eq("Content-Disposition"), any())
    }

    @Test
    fun `error is thrown if the path is missing`()
    {
        val sut = DocumentController(mock(), AppConfig(), Files(), mock())
        assertThatThrownBy { sut.getDocument() }.isInstanceOf(MissingParameterError::class.java)
    }

    @Test
    fun `error is thrown if the file does not exist`()
    {
        val mockContext = mock<ActionContext>() {
            on { splat() } doReturn arrayOf("some", "path", "file.csv")
            on { this.getSparkResponse() } doReturn mockSparkResponse
        }

        val sut = DocumentController(mockContext, AppConfig(), Files(), mock())
        assertThatThrownBy { sut.getDocument() }.isInstanceOf(OrderlyFileNotFoundError::class.java)
    }

    @Test
    fun `creates correct breadcrumbs`()
    {
        val mockRepo = mock<DocumentRepository> {
            on { getAllVisibleDocuments() } doReturn listOf(Document("name", "path", true, listOf()))
        }
        val sut = DocumentController(mock(), AppConfig(), Files(), mockRepo)
        val result = sut.getAll()
        assertThat(result.breadcrumbs[0]).isEqualToComparingFieldByField(IndexViewModel.breadcrumb)
        assertThat(result.breadcrumbs[1].name).isEqualTo("Project documentation")
        assertThat(result.breadcrumbs[1].url).isEqualTo("http://localhost:8888/project-docs")
    }

}