package org.vaccineimpact.orderlyweb.tests.unit_tests.templates

import com.nhaarman.mockito_kotlin.mock
import org.assertj.core.api.Assertions
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.equalTo
import org.hamcrest.Matchers.equalToCompressingWhiteSpace
import org.junit.ClassRule
import org.junit.Test
import org.vaccineimpact.orderlyweb.ActionContext
import org.vaccineimpact.orderlyweb.models.Artefact
import org.vaccineimpact.orderlyweb.models.ArtefactFormat
import org.vaccineimpact.orderlyweb.models.ReportVersionDetails
import org.vaccineimpact.orderlyweb.test_helpers.TeamcityTests
import org.vaccineimpact.orderlyweb.tests.unit_tests.templates.rules.FreemarkerTestRule
import org.vaccineimpact.orderlyweb.viewmodels.ArtefactViewModel
import org.vaccineimpact.orderlyweb.viewmodels.DownloadableFileViewModel
import org.vaccineimpact.orderlyweb.viewmodels.InputDataViewModel
import org.vaccineimpact.orderlyweb.viewmodels.ReportVersionPageViewModel
import org.xmlmatchers.XmlMatchers.hasXPath
import java.sql.Timestamp

//This will also test the partials which the report-page template includes

class VersionPageTests : TeamcityTests()
{
    companion object
    {
        @ClassRule
        @JvmField
        val template = FreemarkerTestRule("report-page.ftl")
    }

    private val testReport = ReportVersionDetails(name = "r1",
            displayName = "r1 display",
            id = "r1-v1",
            published = true,
            date = Timestamp(System.currentTimeMillis()).toInstant(),
            author = "an author",
            requester = "a requester",
            description = "description",
            artefacts = listOf(),
            resources = listOf(),
            dataHashes = mapOf())

    private val testArtefactViewModels = listOf(
            ArtefactViewModel(
                    Artefact(ArtefactFormat.DATA, "artefact1", listOf()),
                    listOf(
                            DownloadableFileViewModel("a1file1.png", "http://a1file1"),
                            DownloadableFileViewModel("a1file2.pdf", "http://a1file2")
                    ),
                    "inlinesrc.png"
            ),
            ArtefactViewModel(
                    Artefact(ArtefactFormat.DATA, "artefact2", listOf()),
                    listOf(
                            DownloadableFileViewModel("a2file1.xls", "http://a2file1")
                    ),
                    null
            )
    )

    private val testDataLinks = listOf(
            InputDataViewModel("key1",
                    DownloadableFileViewModel("key1.csv", "http://key1/csv"),
                    DownloadableFileViewModel("key1.rds", "http://key1/rds")),
            InputDataViewModel("key2",
                    DownloadableFileViewModel("key2.csv", "http://key2/csv"),
                    DownloadableFileViewModel("key2.rds", "http://key2/rds"))
    )

    private val testResources = listOf(
            DownloadableFileViewModel("resource1.csv", "http://resource1/csv"),
            DownloadableFileViewModel("resource2.csv", "http://resource2/csv")
    )

    data class TestReportViewModel(
            val reportJson: String,
            override val report: ReportVersionDetails,
            override val focalArtefactUrl: String?,
            override val isAdmin: Boolean,
            override val artefacts: List<ArtefactViewModel>,
            override val dataLinks: List<InputDataViewModel>,
            override val resources: List<DownloadableFileViewModel>,
            override val zipFile: DownloadableFileViewModel,
            val context: ActionContext) :
            ReportVersionPageViewModel(report, focalArtefactUrl, isAdmin, artefacts, dataLinks, resources, zipFile, context)

    private val testModel = TestReportViewModel(
            "{}",
            testReport,
            "/testFocalArtefactUrl",
            false,
            testArtefactViewModels,
            testDataLinks,
            testResources,
            DownloadableFileViewModel("zipFileName", "http://zipFileUrl"),
            mock()
    )

    @Test
    fun `renders outline correctly`()
    {
        val xmlResponse = template.xmlResponseFor(testModel)

        assertThat(xmlResponse, hasXPath("//li[@class='nav-item'][1]/a[@role='tab']/text()",
                equalToCompressingWhiteSpace("Report")))

        assertThat(xmlResponse, hasXPath("//li[@class='nav-item'][2]/a[@role='tab']/text()",
                equalToCompressingWhiteSpace("Downloads")))

        assertThat(xmlResponse, hasXPath("//div[@class='tab-pane active' and @id='report-tab']"))
        assertThat(xmlResponse, hasXPath("//div[@class='tab-pane' and @id='downloads-tab']"))
    }

    @Test
    fun `renders breadcrumbs correctly`()
    {
        val doc = template.jsoupDocFor(testModel)
        val breadcrumbs = doc.select(".crumb-item")

        Assertions.assertThat(breadcrumbs.count()).isEqualTo(2)
        Assertions.assertThat(breadcrumbs.first().child(0).text()).isEqualTo("Main menu")
        Assertions.assertThat(breadcrumbs.first().child(0).attr("href")).isEqualTo("/")
        Assertions.assertThat(breadcrumbs[1].child(0).text()).isEqualTo("r1 (r1-v1)")
        Assertions.assertThat(breadcrumbs[1].child(0).attr("href")).isEqualTo("/reports/r1/r1-v1/")
    }

    @Test
    fun `renders report tab correctly`()
    {
        val xmlResponse = template.xmlResponseFor(testModel)

        val xPathRoot = "//div[@id='report-tab']"

        assertThat(xmlResponse, hasXPath("$xPathRoot/h1/text()",
                equalToCompressingWhiteSpace("r1 display")))
        assertThat(xmlResponse, hasXPath("$xPathRoot/p[1]/text()",
                equalToCompressingWhiteSpace("r1-v1")))

        assertThat(xmlResponse, hasXPath("$xPathRoot/iframe/@src", equalTo("/testFocalArtefactUrl")))
        assertThat(xmlResponse, hasXPath("$xPathRoot/div[@class='text-right']/a/text()",
                equalToCompressingWhiteSpace("View fullscreen")))
        assertThat(xmlResponse, hasXPath("$xPathRoot/div[@class='text-right']/a/@href", equalTo("/testFocalArtefactUrl")))
    }

    @Test
    fun `renders download tab title correctly`()
    {
        val xmlResponse = template.xmlResponseFor(testModel)

        val xPathRoot = "//div[@id='downloads-tab']"

        assertThat(xmlResponse, hasXPath("$xPathRoot/h1/text()",
                equalToCompressingWhiteSpace("r1 display")))

    }

    @Test
    fun `renders download tab artefacts correctly`()
    {
        val jsoupDoc = template.jsoupDocFor(testModel)

        val artefactsEl = jsoupDoc.select("#artefacts")
        val artefactCards = artefactsEl.select(".card")
        Assertions.assertThat(artefactCards.count()).isEqualTo(2)

        val artefactEl1 = artefactCards[0]
        Assertions.assertThat(artefactEl1.select(".card-header").text()).isEqualTo("artefact1")
        Assertions.assertThat(artefactEl1.select("img").attr("src")).isEqualTo("inlinesrc.png")
        val artefact1FileLinks = artefactEl1.select(".card-body div a")

        Assertions.assertThat(artefact1FileLinks.count()).isEqualTo(2)
        Assertions.assertThat(artefact1FileLinks[0].attr("href")).isEqualTo("http://a1file1")
        Assertions.assertThat(artefact1FileLinks[0].text()).isEqualTo("a1file1.png")
        Assertions.assertThat(artefact1FileLinks[0].select("span.download-icon").count()).isEqualTo(1)
        Assertions.assertThat(artefact1FileLinks[1].attr("href")).isEqualTo("http://a1file2")
        Assertions.assertThat(artefact1FileLinks[1].text()).isEqualTo("a1file2.pdf")
        Assertions.assertThat(artefact1FileLinks[1].select("span.download-icon").count()).isEqualTo(1)


        val artefactEl2 = artefactCards[1]
        Assertions.assertThat(artefactEl2.select(".card-header").text()).isEqualTo("artefact2")
        Assertions.assertThat(artefactEl2.select("img").count()).isEqualTo(0)
        val artefact2FileLinks = artefactEl2.select(".card-body div a")
        Assertions.assertThat(artefact2FileLinks.count()).isEqualTo(1)
        Assertions.assertThat(artefact2FileLinks[0].attr("href")).isEqualTo("http://a2file1")
        Assertions.assertThat(artefact2FileLinks[0].text()).isEqualTo("a2file1.xls")
    }

    @Test
    fun `renders download tab data links correctly`()
    {
        val jsoupDoc = template.jsoupDocFor(testModel)

        val linksEl = jsoupDoc.select("#data-links")
        Assertions.assertThat(linksEl.select(".card-header").text()).isEqualTo("Input data to the report")

        val linkRows = linksEl.select(".row")
        Assertions.assertThat(linkRows.count()).isEqualTo(2)

        val linkRow1 = linkRows[0]
        Assertions.assertThat(linkRow1.select(".data-link-key").text()).isEqualTo("key1")
        val linkRow1Csv = linkRow1.select("ul li")[0]
        Assertions.assertThat(linkRow1Csv.select("a").attr("href")).isEqualTo("http://key1/csv")
        Assertions.assertThat(linkRow1Csv.select("a").text()).isEqualTo("key1.csv")
        val linkRow1Rds = linkRow1.select("ul li")[1]
        Assertions.assertThat(linkRow1Rds.select("a").attr("href")).isEqualTo("http://key1/rds")
        Assertions.assertThat(linkRow1Rds.select("a").text()).isEqualTo("key1.rds")

        val linkRow2 = linkRows[1]
        Assertions.assertThat(linkRow2.select(".data-link-key").text()).isEqualTo("key2")
        val linkRow2Csv = linkRow2.select("ul li")[0]
        Assertions.assertThat(linkRow2Csv.select("a").attr("href")).isEqualTo("http://key2/csv")
        Assertions.assertThat(linkRow2Csv.select("a").text()).isEqualTo("key2.csv")
        val linkRow2Rds = linkRow2.select("ul li")[1]
        Assertions.assertThat(linkRow2Rds.select("a").attr("href")).isEqualTo("http://key2/rds")
        Assertions.assertThat(linkRow2Rds.select("a").text()).isEqualTo("key2.rds")
    }

    @Test
    fun `does not render download tab data links if none in model`()
    {
        val testModel = testModel.copy(dataLinks = listOf())

        val jsoupDoc = template.jsoupDocFor(testModel)

        val linksEl = jsoupDoc.select("#data-links")
        Assertions.assertThat(linksEl.count()).isEqualTo(0)
    }

    @Test
    fun `renders resources correctly`()
    {
        val jsoupDoc = template.jsoupDocFor(testModel)

        val resourcesEl = jsoupDoc.select("#resources")
        Assertions.assertThat(resourcesEl.select(".card-header").text()).isEqualTo("Resources")

        val resourceLinks = resourcesEl.select(".card-body div a")
        Assertions.assertThat(resourceLinks.count()).isEqualTo(2)
        Assertions.assertThat(resourceLinks[0].attr("href")).isEqualTo("http://resource1/csv")
        Assertions.assertThat(resourceLinks[0].text()).isEqualTo("resource1.csv")
        Assertions.assertThat(resourceLinks[0].select("span.download-icon").count()).isEqualTo(1)
        Assertions.assertThat(resourceLinks[1].attr("href")).isEqualTo("http://resource2/csv")
        Assertions.assertThat(resourceLinks[1].text()).isEqualTo("resource2.csv")
        Assertions.assertThat(resourceLinks[1].select("span.download-icon").count()).isEqualTo(1)
    }

    @Test
    fun `renders zipfile correctly`()
    {
        val jsoupDoc = template.jsoupDocFor(testModel)

        val zipFileEl = jsoupDoc.select("#zip-file")
        val zipFileLink = zipFileEl.select("a")
        Assertions.assertThat(zipFileLink.attr("href")).isEqualTo("http://zipFileUrl")
        Assertions.assertThat(zipFileLink.text()).isEqualTo("zipFileName")
        Assertions.assertThat(zipFileLink.select("span.download-icon").count()).isEqualTo(1)
    }

    @Test
    fun `does not render download tab resources if none in model`()
    {
        val testModel = testModel.copy(resources = listOf())
        val jsoupDoc = template.jsoupDocFor(testModel)

        val resourcesEl = jsoupDoc.select("#resources")
        Assertions.assertThat(resourcesEl.count()).isEqualTo(0)
    }

    @Test
    fun `admins see publish switch`()
    {
        val mockModel = testModel.copy(isAdmin = true)

        val htmlResponse = template.htmlPageResponseFor(mockModel)

        val publishSwitch = htmlResponse.getElementById("publishSwitchVueApp")
        Assertions.assertThat(publishSwitch).isNotNull()
    }

    @Test
    fun `non admins do not see publish switch`()
    {
        val mockModel = testModel.copy(isAdmin = false)

        val htmlResponse = template.htmlPageResponseFor(mockModel)

        val publishSwitch = htmlResponse.getElementById("publishSwitchVueApp")
        Assertions.assertThat(publishSwitch).isNull()
    }
}