package org.vaccineimpact.orderlyweb.tests.integration_tests.tests.web

import org.junit.Test
import org.vaccineimpact.orderlyweb.ContentTypes
import org.vaccineimpact.orderlyweb.models.Scope
import org.vaccineimpact.orderlyweb.models.permissions.ReifiedPermission
import org.vaccineimpact.orderlyweb.tests.integration_tests.tests.IntegrationTest
import spark.route.HttpMethod

class UsersTests : IntegrationTest()
{
    @Test
    fun `only user managers can get report readers`()
    {
        val url = "/users/report-readers/minimal"

        assertWebUrlSecured(url, setOf(ReifiedPermission("users.manage", Scope.Global())),
                contentType = ContentTypes.json)
    }

    @Test
    fun `only user managers can associate permission`()
    {
        val url = "/users/test.user%40example.com/associate-permission/"

        assertWebUrlSecured(url, setOf(ReifiedPermission("users.manage", Scope.Global())),
                contentType = ContentTypes.json, method = HttpMethod.post)
    }

}