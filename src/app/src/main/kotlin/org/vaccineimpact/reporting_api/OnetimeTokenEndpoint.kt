package org.vaccineimpact.reporting_api

import org.vaccineimpact.reporting_api.db.Config
import org.vaccineimpact.reporting_api.db.TokenStore
import org.vaccineimpact.reporting_api.security.*
import spark.Spark
import spark.route.HttpMethod

data class OnetimeTokenEndpoint(
        override val urlFragment: String,
        override val controllerName: String,
        override val actionName: String,
        override val contentType: String = ContentTypes.binarydata,
        override val method: HttpMethod = HttpMethod.get
) : EndpointDefinition
{
    init
    {
        if (!urlFragment.endsWith("/"))
        {
            throw Exception("All endpoint definitions must end with a forward slash: $urlFragment")
        }
    }

    override fun additionalSetup(url: String)
    {
        val allPermissions = setOf("*/reports.read").map {
            PermissionRequirement.parse(it)
        }

        val bearerTokenVerifier = TokenVerifier(KeyHelper.authPublicKey, Config["token.issuer"])
        val onetimeTokenVerifier = WebTokenHelper.oneTimeTokenHelper.verifier

        val configFactory = TokenVerifyingConfigFactory(
                listOf(JWTHeaderClientWrapper(bearerTokenVerifier),
                        JWTParameterClientWrapper(onetimeTokenVerifier,
                                TokenStore(),
                                url)),
                allPermissions.toSet())

        val config = configFactory.build()

        Spark.before(url, org.pac4j.sparkjava.SecurityFilter(
                config,
                configFactory.allClients(),
                MontaguAuthorizer::class.java.simpleName,
                "SkipOptions"
        ))
    }

}