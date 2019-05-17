package org.vaccineimpact.orderlyweb.tests.integration_tests.tests.api

import org.assertj.core.api.Assertions
import org.junit.Test
import org.vaccineimpact.orderlyweb.ContentTypes
import org.vaccineimpact.orderlyweb.db.Orderly
import org.vaccineimpact.orderlyweb.db.AppConfig
import org.vaccineimpact.orderlyweb.tests.insertArtefact
import org.vaccineimpact.orderlyweb.test_helpers.insertReport
import org.vaccineimpact.orderlyweb.tests.integration_tests.helpers.fakeGlobalReportReviewer
import org.vaccineimpact.orderlyweb.tests.integration_tests.helpers.fakeReportReader
import org.vaccineimpact.orderlyweb.tests.integration_tests.tests.IntegrationTest
import java.io.File

class ArtefactTests : IntegrationTest()
{
    @Test
    fun `gets dict of artefact names to hashes with report scoped permission`()
    {
        insertReport("testname", "testversion")
        val response = apiRequestHelper.get("/reports/testname/versions/testversion/artefacts/",
                userEmail = fakeReportReader("testname"))


        assertJsonContentType(response)
        assertSuccessful(response)
        JSONValidator.validateAgainstSchema(response.text, "Dictionary")
    }

    @Test
    fun `cant get artefacts dict if report not within report reading scope`()
    {
        insertReport("testname", "testversion")
        val response = apiRequestHelper.get("/reports/testname/versions/testversion/artefacts/",
                userEmail = fakeReportReader("badreportname"))

        assertUnauthorized(response, "testname")
    }

    @Test
    fun `gets artefact file with access token`()
    {
        val publishedVersion = Orderly().getReportsByName("other")[0]

        val url = "/reports/other/versions/$publishedVersion/artefacts/graph.png/"
        val token = apiRequestHelper.generateOnetimeToken(url)
        val response = apiRequestHelper.getNoAuth("$url?access_token=$token", ContentTypes.binarydata)

        assertSuccessful(response)
        Assertions.assertThat(response.headers["content-type"]).isEqualTo("image/png")
        Assertions.assertThat(response.headers["content-disposition"]).isEqualTo("attachment; filename=\"other/$publishedVersion/graph.png\"")
    }

    @Test
    fun `gets artefact file with bearer token`()
    {
        val publishedVersion = Orderly().getReportsByName("other")[0]

        val url = "/reports/other/versions/$publishedVersion/artefacts/graph.png/"
        val response = apiRequestHelper.get(url, ContentTypes.binarydata)

        assertSuccessful(response)
        Assertions.assertThat(response.headers["content-type"]).isEqualTo("image/png")
        Assertions.assertThat(response.headers["content-disposition"]).isEqualTo("attachment; filename=\"other/$publishedVersion/graph.png\"")
    }

    @Test
    fun `gets artefact file with bearer token without trailing slash`()
    {
        val publishedVersion = Orderly().getReportsByName("other")[0]

        val url = "/reports/other/versions/$publishedVersion/artefacts/graph.png"
        val response = apiRequestHelper.get(url, ContentTypes.binarydata)

        assertSuccessful(response)
        Assertions.assertThat(response.headers["content-type"]).isEqualTo("image/png")
        Assertions.assertThat(response.headers["content-disposition"]).isEqualTo("attachment; filename=\"other/$publishedVersion/graph.png\"")
    }

    @Test
    fun `gets artefact file with space in name`()
    {
        val version = File("${AppConfig()["orderly.root"]}/archive/spaces/").list()[0]

        val url = "/reports/spaces/versions/$version/artefacts/a+graph+with+spaces.png"
        val response = apiRequestHelper.get(url, ContentTypes.binarydata, userEmail = fakeGlobalReportReviewer())

        assertSuccessful(response)
        Assertions.assertThat(response.headers["content-type"]).isEqualTo("image/png")
        Assertions.assertThat(response.headers["content-disposition"]).isEqualTo("attachment; filename=\"spaces/$version/a graph with spaces.png\"")
    }

    @Test
    fun `can get artefact file with scoped report reading permission`()
    {
        val publishedVersion = Orderly().getReportsByName("other")[0]

        val url = "/reports/other/versions/$publishedVersion/artefacts/graph.png/"
        val response = apiRequestHelper.get(url, ContentTypes.binarydata,
                userEmail = fakeReportReader("other"))

        assertSuccessful(response)
    }

    @Test
    fun `can't get artefact file if report not within report reading scope`()
    {
        val publishedVersion = Orderly().getReportsByName("other")[0]

        val url = "/reports/other/versions/$publishedVersion/artefacts/graph.png/"
        val response = apiRequestHelper.get(url, ContentTypes.binarydata,
                userEmail = fakeReportReader("badreportname"))

        assertUnauthorized(response, "other")
    }

    @Test
    fun `gets 404 if artefact doesnt exist in db`()
    {
        insertReport("testname", "testversion")
        val fakeartefact = "hf647rhj"
        val url = "/reports/testname/versions/testversion/artefacts/$fakeartefact/"
        val token = apiRequestHelper.generateOnetimeToken(url)
        val response = apiRequestHelper.getNoAuth("$url?access_token=$token", ContentTypes.binarydata)

        assertJsonContentType(response)
        Assertions.assertThat(response.statusCode).isEqualTo(404)
        JSONValidator.validateError(response.text, "unknown-artefact", "Unknown artefact : '$fakeartefact'")
    }

    @Test
    fun `gets 404 if artefact file doesnt exist`()
    {
        val fakeartefact = "64328fyhdkjs.csv"
        val url = "/reports/testname/versions/testversion/artefacts/$fakeartefact/"
        val token = apiRequestHelper.generateOnetimeToken(url)

        insertReport("testname", "testversion")
        insertArtefact("testversion", fileNames = listOf(fakeartefact))
        val response = apiRequestHelper.getNoAuth("$url?access_token=$token", ContentTypes.binarydata)

        assertJsonContentType(response)
        Assertions.assertThat(response.statusCode).isEqualTo(404)
        JSONValidator.validateError(response.text, "file-not-found", "File with name '$fakeartefact' does not exist")
    }


}