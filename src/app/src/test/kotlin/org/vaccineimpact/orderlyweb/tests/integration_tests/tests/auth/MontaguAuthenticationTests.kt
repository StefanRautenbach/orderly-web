package org.vaccineimpact.orderlyweb.tests.integration_tests.tests.auth

import org.assertj.core.api.Assertions
import org.junit.Test
import org.vaccineimpact.orderlyweb.tests.integration_tests.helpers.RequestHelper
import org.vaccineimpact.orderlyweb.tests.integration_tests.tests.IntegrationTest

class MontaguAuthenticationTests : IntegrationTest()
{
    @Test
    fun `user is redirected to Montagu if not logged in`()
    {
        val response = khttp.get(RequestHelper()
                .webBaseUrl, allowRedirects = false)
        Assertions.assertThat(response.statusCode).isEqualTo(302)
    }

    @Test
    fun `user can login with Montagu cookie`()
    {
        val loginResponse = RequestHelper()
                .getWithMontaguCookie("/login")

        // the session cookie should now have been set
        // so pull this out of the response and send it back
        val cookie = loginResponse.headers["Set-Cookie"]

        val response = khttp.get(RequestHelper().webBaseUrl,
                headers = mapOf("Cookie" to cookie!!))

        Assertions.assertThat(response.statusCode).isEqualTo(200)
    }

    @Test
    fun `user can logout`()
    {
        //login
        val loginResponse = RequestHelper().getWithMontaguCookie("/login")

        //logout
        val cookie = loginResponse.headers["Set-Cookie"]
        khttp.get("${RequestHelper().webBaseUrl}/logout",
                headers = mapOf("Cookie" to cookie!!))

        //after logout, user should be redirected when attempt to access base url
        val response = khttp.get(RequestHelper()
                .webBaseUrl, allowRedirects = false)
        Assertions.assertThat(response.statusCode).isEqualTo(302)
    }
}