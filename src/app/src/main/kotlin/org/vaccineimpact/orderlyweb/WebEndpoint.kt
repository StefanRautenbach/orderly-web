package org.vaccineimpact.orderlyweb

import org.pac4j.core.config.ConfigFactory
import org.vaccineimpact.orderlyweb.models.PermissionRequirement
import org.vaccineimpact.orderlyweb.security.authentication.AuthenticationConfig
import org.vaccineimpact.orderlyweb.security.SkipOptionsMatcher
import org.vaccineimpact.orderlyweb.security.WebSecurityConfigFactory
import org.vaccineimpact.orderlyweb.security.authentication.AuthenticationProvider
import org.vaccineimpact.orderlyweb.security.clients.OrderlyWebIndirectClient

import spark.route.HttpMethod
import kotlin.reflect.KClass

data class WebEndpoint(
        override val urlFragment: String,
        override val controller: KClass<*>,
        override val actionName: String,
        override val method: HttpMethod = HttpMethod.get,
        override val requiredPermissions: List<PermissionRequirement> = listOf(),
        override val secure: Boolean = false,
        override val contentType: String = ContentTypes.html,
        val externalAuth: Boolean = false,
        val spark: SparkWrapper = SparkServiceWrapper(),
        val configFactory: ConfigFactory? = null,
        val authenticationConfig: AuthenticationConfig = AuthenticationConfig()
) : EndpointDefinition
{
    override val transform = false
    override val allowParameterAuthentication = false
    override val authenticateWithExternalProvider: Boolean = true

    override fun additionalSetup(url: String)
    {
        if (secure)
        {
            addSecurityFilter(url)
        }
    }

    private fun addSecurityFilter(url: String)
    {

        val client =
                if (externalAuth)
                {
                    //The endpoints with externalAuth are those which will redirect the user to a specific external Auth provider
                    //after clicking a link on our login page.
                    authenticationConfig.getAuthenticationIndirectClient()
                }
                else
                {
                    //Redirect to our login page, or to an external login provider if OrderlyWeb actions should be fully
                    //synchronised with external login provider, and login page should not be seen (Montagu only)
                    val synchronisedAuth = authenticationConfig.getConfiguredProvider() == AuthenticationProvider.Montagu
                    if (synchronisedAuth)
                        authenticationConfig.getAuthenticationIndirectClient()
                    else
                        OrderlyWebIndirectClient()
                }

        val factory = configFactory ?: WebSecurityConfigFactory(
                client,
                this.requiredPermissions.toSet())

        val config = factory.build()

        spark.before(url, org.pac4j.sparkjava.SecurityFilter(
                config,
                client.javaClass.simpleName,
                config.authorizers.map { it.key }.joinToString(","),
                SkipOptionsMatcher.name
        ))

    }

}

fun WebEndpoint.secure(permissions: Set<String> = setOf(), externalAuth: Boolean = false): WebEndpoint
{
    val allPermissions = (permissions).map {
        PermissionRequirement.parse(it)
    }
    return this.copy(requiredPermissions = allPermissions, secure = true, externalAuth = externalAuth)
}

fun WebEndpoint.post(): WebEndpoint
{
    return this.copy(method = HttpMethod.post)
}

fun WebEndpoint.json(): WebEndpoint
{
    return this.copy(contentType = ContentTypes.json)
}
