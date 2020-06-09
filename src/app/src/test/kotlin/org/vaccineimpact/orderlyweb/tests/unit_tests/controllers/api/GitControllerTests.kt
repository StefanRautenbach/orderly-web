package org.vaccineimpact.orderlyweb.tests.unit_tests.controllers.api

import com.nhaarman.mockito_kotlin.*
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test
import org.vaccineimpact.orderlyweb.ActionContext
import org.vaccineimpact.orderlyweb.OrderlyServerAPI
import org.vaccineimpact.orderlyweb.OrderlyServerResponse
import org.vaccineimpact.orderlyweb.controllers.api.GitController

class GitControllerTests : ControllerTest()
{
    private val mockContext = mock<ActionContext>()
    private val mockResponse = OrderlyServerResponse("testResponse", 200)

    @Test
    fun `status gets status from orderly`()
    {
        val mockOrderly = mock<OrderlyServerAPI>{
            on { it.get("/reports/git/status/", mockContext) } doReturn mockResponse
        }

        val sut = GitController(mockContext, mockOrderly)
        val response = sut.status()

        assertThat(response).isEqualTo("testResponse")
    }

    @Test
    fun `fetch gets response from orderly`()
    {
        val mockOrderly = mock<OrderlyServerAPI>{
            on { it.post("/reports/git/fetch/", mockContext) } doReturn mockResponse
        }

        val sut = GitController(mockContext, mockOrderly)
        val response = sut.fetch()

        assertThat(response).isEqualTo("testResponse")
    }

    @Test
    fun `pull gets response from orderly`()
    {
        val mockOrderly = mock<OrderlyServerAPI>{
            on { it.post("/reports/git/pull/", mockContext) } doReturn mockResponse
        }

        val sut = GitController(mockContext, mockOrderly)
        val response = sut.pull()

        assertThat(response).isEqualTo("testResponse")
    }
}