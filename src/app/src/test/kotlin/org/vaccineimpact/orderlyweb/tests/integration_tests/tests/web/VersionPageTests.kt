package org.vaccineimpact.orderlyweb.tests.integration_tests.tests.web

import org.assertj.core.api.Assertions
import org.jsoup.Jsoup
import org.junit.Test
import org.vaccineimpact.orderlyweb.ContentTypes
import org.vaccineimpact.orderlyweb.db.JooqContext
import org.vaccineimpact.orderlyweb.db.Tables.*
import org.vaccineimpact.orderlyweb.db.fromJoinPath
import org.vaccineimpact.orderlyweb.models.FilePurpose
import org.vaccineimpact.orderlyweb.models.Scope
import org.vaccineimpact.orderlyweb.models.permissions.ReifiedPermission
import org.vaccineimpact.orderlyweb.tests.integration_tests.tests.IntegrationTest

class VersionPageTests : IntegrationTest()
{
    private val readReports = setOf(ReifiedPermission("reports.read", Scope.Global()))

    @Test
    fun `artefacts can be downloaded`()
    {
        val sessionCookie = webRequestHelper.webLoginWithMontagu(readReports)
        val response = webRequestHelper.requestWithSessionCookie(getAnyReportPageUrl(), sessionCookie)
        val page = Jsoup.parse(response.text)

        val firstArtefactHref = page.selectFirst("#artefacts a").attr("href")

        val result = webRequestHelper.requestWithSessionCookie(firstArtefactHref, sessionCookie, ContentTypes.binarydata)

        Assertions.assertThat(result.statusCode).isEqualTo(200)
    }

    @Test
    fun `data can be downloaded`()
    {
        val sessionCookie = webRequestHelper.webLoginWithMontagu(readReports)
        val response = webRequestHelper.requestWithSessionCookie(getAnyReportPageUrl(), sessionCookie)
        val page = Jsoup.parse(response.text)

        val firstDataHref = page.selectFirst("#data-links a").attr("href")

        val result = webRequestHelper.requestWithSessionCookie(firstDataHref, sessionCookie, ContentTypes.binarydata)

        Assertions.assertThat(result.statusCode).isEqualTo(200)
    }

    @Test
    fun `resources can be downloaded`()
    {
        val sessionCookie = webRequestHelper.webLoginWithMontagu(readReports)
        val response = webRequestHelper.requestWithSessionCookie(getAnyReportPageUrl(), sessionCookie)
        val page = Jsoup.parse(response.text)

        val firstDataHref = page.selectFirst("#resources a").attr("href")

        val result = webRequestHelper.requestWithSessionCookie(firstDataHref, sessionCookie, ContentTypes.binarydata)

        Assertions.assertThat(result.statusCode).isEqualTo(200)
    }

    @Test
    fun `zip file can be downloaded`()
    {
        val sessionCookie = webRequestHelper.webLoginWithMontagu(readReports)
        val response = webRequestHelper.requestWithSessionCookie(getAnyReportPageUrl(), sessionCookie)
        val page = Jsoup.parse(response.text)

        val href = page.selectFirst("#zip-file a").attr("href")

        val result = webRequestHelper.requestWithSessionCookie(href, sessionCookie, ContentTypes.binarydata)

        Assertions.assertThat(result.statusCode).isEqualTo(200)
    }

    private fun getAnyReportPageUrl(): String
    {
        val data = JooqContext().use {

            it.dsl.select(REPORT_VERSION.REPORT, REPORT_VERSION.ID)
                    .fromJoinPath(REPORT_VERSION_DATA, REPORT_VERSION, FILE_INPUT)
                    .where(REPORT_VERSION.PUBLISHED.eq(true))
                    .and(FILE_INPUT.FILE_PURPOSE.eq(FilePurpose.RESOURCE.toString()))
                    .fetchAny()
        }

        val report = data[REPORT_VERSION.REPORT]
        val version = data[REPORT_VERSION.ID]

        return "/reports/$report/$version/"
    }
}