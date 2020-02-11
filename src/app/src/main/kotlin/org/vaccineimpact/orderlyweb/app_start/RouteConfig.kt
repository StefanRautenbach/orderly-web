package org.vaccineimpact.orderlyweb.app_start

import org.vaccineimpact.orderlyweb.*
import org.vaccineimpact.orderlyweb.app_start.routing.api.*
import org.vaccineimpact.orderlyweb.app_start.routing.web.*
import org.vaccineimpact.orderlyweb.controllers.web.IndexController
import org.vaccineimpact.orderlyweb.controllers.web.AdminController

interface RouteConfig
{
    val endpoints: List<EndpointDefinition>
}

object APIRouteConfig : RouteConfig
{
    override val endpoints: List<EndpointDefinition> =
            GitRouteConfig.endpoints.plus(ReportRouteConfig.endpoints)
                    .plus(VersionRouteConfig.endpoints)
                    .plus(HomeRouteConfig.endpoints)
                    .plus(DataRouteConfig.endpoints)
                    .plus(UserRouteConfig.endpoints)
                    .plus(DocumentRouteConfig.endpoints)
}

object WebRouteConfig : RouteConfig
{
    private val metricsEndpoint = WebEndpoint("/metrics/", IndexController::class, "metrics")
            .json()

    private val adminEndpoint = WebEndpoint("/manage-access/", AdminController:: class, "admin")
            .secure(setOf("*/users.manage"))

    override val endpoints: List<EndpointDefinition> =
            WebAuthRouteConfig.endpoints +
                    WebDocumentRouteConfig.endpoints +
                    WebReportRouteConfig.endpoints +
                    WebVersionRouteConfig.endpoints +
                    WebUserRouteConfig.endpoints +
                    WebPermissionRouteConfig.endpoints +
                    WebRoleRouteConfig.endpoints + metricsEndpoint + adminEndpoint
}

