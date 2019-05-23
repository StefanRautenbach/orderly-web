package org.vaccineimpact.orderlyweb.tests.unit_tests.controllers.web

import com.nhaarman.mockito_kotlin.doReturn
import com.nhaarman.mockito_kotlin.mock
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test
import org.vaccineimpact.orderlyweb.ActionContext
import org.vaccineimpact.orderlyweb.controllers.web.IndexController
import org.vaccineimpact.orderlyweb.db.Orderly
import org.vaccineimpact.orderlyweb.db.OrderlyClient
import org.vaccineimpact.orderlyweb.models.ReportVersion
import org.vaccineimpact.orderlyweb.models.Scope
import org.vaccineimpact.orderlyweb.models.permissions.ReifiedPermission
import org.vaccineimpact.orderlyweb.test_helpers.TeamcityTests
import org.vaccineimpact.orderlyweb.viewmodels.ReportRowViewModel
import java.time.Instant

class HomeControllerTests : TeamcityTests()
{
    @Test
    fun `initialises Orderly correctly when user is reviewer`()
    {
        val mockContext = mock<ActionContext> {
            on { this.hasPermission(ReifiedPermission("reports.review", Scope.Global())) } doReturn true
        }

        val sut = IndexController(mockContext)

        assertThat((sut.orderly as Orderly).isReviewer).isTrue()
    }

    @Test
    fun `initialises Orderly correctly when user is not reviewer`()
    {
        val mockContext = mock<ActionContext> {
            on { this.hasPermission(ReifiedPermission("reports.review", Scope.Global())) } doReturn false
        }

        val sut = IndexController(mockContext)

        assertThat((sut.orderly as Orderly).isReviewer).isFalse()
    }

    @Test
    fun `builds report rows`()
    {
        val author = "dr authorson"
        val requester = "funder mcfunderson"
        val date = Instant.parse("2019-05-23T12:31:00.613Z")
        val fakeReports = listOf(ReportVersion("r1", "r1 display name", "v1", "v2", true, date, author, requester),
                ReportVersion("r1", "r1 display name", "v2", "v2", false, date, author, requester),
                ReportVersion("r2", "r2 display name", "r2v1", "v1", true, date, "new author", "new requester"))

        val mockOrderly = mock<OrderlyClient>() {
            on { this.getAllReportVersions() } doReturn fakeReports
        }
        val sut = IndexController(mock(), mockOrderly)

        val result = sut.index().reports.sortedBy { it.ttKey }

        val expected = listOf(ReportRowViewModel(1, 0, "r1", null, "v2", null, 2, null, null, null),
                ReportRowViewModel(2, 1, "r1", "v1", "v2", "Thurs 23 May 2019 12:31", 2, false, author, requester),
                ReportRowViewModel(3, 1, "r1", "v2", "v2", "Thurs 23 May 2019 12:31", 2, true, author, requester),
                ReportRowViewModel(4, 0, "r2", null, "r2v1", null, 1, null, null, null),
                ReportRowViewModel(5, 4, "r2", "r2v2", "r2v1", "Thurs 23 May 2019 12:31", 2, true, "new author", "new requester")
        )

        assertThat(result.count()).isEqualTo(5)
        (0..4).map {
            assertThat(result[it]).isEqualToComparingFieldByField(expected[it])
        }

    }

}

