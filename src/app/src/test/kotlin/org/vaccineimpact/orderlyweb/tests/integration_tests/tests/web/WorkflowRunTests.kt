package org.vaccineimpact.orderlyweb.tests.integration_tests.tests.web

import org.assertj.core.api.Assertions.assertThat
import org.eclipse.jetty.http.HttpStatus
import org.junit.Before
import org.junit.Test
import org.vaccineimpact.orderlyweb.ContentTypes
import org.vaccineimpact.orderlyweb.db.repositories.OrderlyWebWorkflowRunRepository
import org.vaccineimpact.orderlyweb.models.Scope
import org.vaccineimpact.orderlyweb.models.WorkflowReportWithParams
import org.vaccineimpact.orderlyweb.models.WorkflowRun
import org.vaccineimpact.orderlyweb.models.permissions.ReifiedPermission
import org.vaccineimpact.orderlyweb.tests.insertUser
import org.vaccineimpact.orderlyweb.tests.integration_tests.tests.IntegrationTest
import spark.route.HttpMethod
import java.time.Instant

class WorkflowRunTests : IntegrationTest()
{
    @Before
    fun setup()
    {
        addDataToWorkflowTable()
    }

    @Test
    fun `only report runners can view workflow details`()
    {
        val url = "/view-workflow?key=adventurous_aardvark"
        val requiredPermissions = setOf(ReifiedPermission("reports.run", Scope.Global()))
        assertWebUrlSecured(url, requiredPermissions, contentType = ContentTypes.json)
    }

    @Test
    fun `can get workflow details`()
    {
        val url = "/view-workflow/?key=adventurous_aardvark"
        val response = webRequestHelper.loginWithMontaguAndMakeRequest(url,
                setOf(ReifiedPermission("reports.run", Scope.Global())),
                method = HttpMethod.get,
                contentType = ContentTypes.json)

        assertSuccessful(response)
        assertJsonContentType(response)

        val responseData = JSONValidator.getData(response.text)
        assertThat(responseData["name"].textValue()).isEqualTo("Interim report")
        assertThat(responseData["key"].textValue()).isEqualTo("adventurous_aardvark")
        assertThat(responseData["email"].textValue()).isEqualTo("user@email.com")
    }

    @Test
    fun `does not get workflow details if key is invalid`()
    {
        val url = "/view-workflow/?key=fakeKey"
        val response = webRequestHelper.loginWithMontaguAndMakeRequest(url,
                setOf(ReifiedPermission("reports.run", Scope.Global())),
                method = HttpMethod.get,
                contentType = ContentTypes.json)

        assertJsonContentType(response)
        assertThat(response.statusCode).isNotEqualTo(HttpStatus.OK_200)
    }

    private fun addDataToWorkflowTable()
    {
        insertUser("user@email.com", "user.name")

        val now = Instant.now()

        val workflowRun = WorkflowRun(
                "Interim report",
                "adventurous_aardvark",
                "user@email.com",
                now,
                listOf(
                        WorkflowReportWithParams("reportA", mapOf("param1" to "one", "param2" to "two")),
                        WorkflowReportWithParams("reportB", mapOf("param3" to "three"))
                ),
                mapOf("instanceA" to "pre-staging"),
                "branch1",
                "commit1"
        )

        val sut = OrderlyWebWorkflowRunRepository()
        sut.addWorkflowRun(workflowRun)
    }
}
