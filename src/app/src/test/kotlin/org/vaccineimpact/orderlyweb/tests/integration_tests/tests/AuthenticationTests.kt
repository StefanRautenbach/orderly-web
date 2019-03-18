package org.vaccineimpact.orderlyweb.tests.integration_tests.tests

import com.github.fge.jackson.JsonLoader
import khttp.options
import khttp.post
import khttp.responses.Response
import khttp.structures.authorization.Authorization
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test
import org.vaccineimpact.orderlyweb.tests.integration_tests.helpers.RequestHelper
import java.util.*

class AuthenticationTests : IntegrationTest()
{
    @Test
    fun `authentication fails without Auth header`()
    {
        val result = post(url)
        assertThat(result.statusCode).isEqualTo(401)
        JSONValidator.validateError(result.text,
                expectedErrorCode = "github-token-invalid",
                expectedErrorText = "GitHub token not supplied in Authorization header, or GitHub token was invalid")
    }

    @Test
    fun `authentication fails with malformed Auth header`()
    {
        val result = post(url, auth = GithubTokenHeader("token","bearer"))
        assertThat(result.statusCode).isEqualTo(401)
        JSONValidator.validateError(result.text,
                expectedErrorCode = "github-token-invalid",
                expectedErrorText = "GitHub token not supplied in Authorization header, or GitHub token was invalid")
    }

    @Test
    fun `authentication succeeds with well-formed Auth header`()
    {
        val result = post(url, auth = GithubTokenHeader("token"))
        assertSuccessful(result)

        val json = JsonLoader.fromString(result.text)
        assertThat(json["token_type"].textValue()).isEqualTo("bearer")
        assertThat(json["access_token"]).isNotNull
        assertThat(isLong(json["expires_in"].toString())).isTrue()
    }

    @Test
    fun `can get OPTIONS for authentication endpoint`()
    {
        val result = options(url)
        assertThat(result.statusCode).isEqualTo(200)
    }

    private fun isLong(raw: String): Boolean
    {
        try
        {
            raw.toLong()
            return true
        }
        catch (e: NumberFormatException)
        {
            return false
        }
    }

    val url = "${RequestHelper().baseUrl}/login/"

    data class GithubTokenHeader(val token: String, val prefix: String = "token") : Authorization
    {
        override val header: Pair<String, String>
            get()
            {
                val b64 = Base64.getEncoder().encode(token.toByteArray()).toString(Charsets.UTF_8)
                return "Authorization" to "$prefix $b64"
            }
    }

}