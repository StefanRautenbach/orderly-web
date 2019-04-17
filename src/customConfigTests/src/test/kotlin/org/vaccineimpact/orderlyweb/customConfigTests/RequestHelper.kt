package org.vaccineimpact.orderlyweb.customConfigTests

import com.beust.klaxon.JsonObject
import com.beust.klaxon.Parser
import khttp.responses.Response
import khttp.structures.authorization.BasicAuthorization
import org.vaccineimpact.orderlyweb.ContentTypes
import org.vaccineimpact.orderlyweb.db.AppConfig
import org.vaccineimpact.orderlyweb.security.WebTokenHelper
import org.vaccineimpact.orderlyweb.security.clients.MontaguIndirectClient

class RequestHelper
{
    companion object
    {
        val apiBaseUrl: String = "http://localhost:${AppConfig()["app.port"]}/api/v1"
        val webBaseUrl: String = "http://localhost:${AppConfig()["app.port"]}"
    }

    fun get(url: String, contentType: String = ContentTypes.json,
            userEmail: String): Response
    {
        val token = generateToken(userEmail)
        val headers = standardHeaders(contentType).withAuthorizationHeader(token)
        return get(apiBaseUrl + url, headers)
    }

    private fun standardHeaders(contentType: String): Map<String, String>
    {
        return mapOf(
                "Accept" to contentType,
                "Accept-Encoding" to "gzip"
        )
    }

    private fun Map<String, String>.withAuthorizationHeader(token: String) = this +
            mapOf("Authorization" to "Bearer $token")

    private fun get(url: String, headers: Map<String, String>) = khttp.get(url, headers)

    private fun generateToken(emailAddress: String) =
            WebTokenHelper.instance.issuer.generateBearerToken(emailAddress)

}