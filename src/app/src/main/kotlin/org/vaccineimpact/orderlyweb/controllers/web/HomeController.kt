package org.vaccineimpact.orderlyweb.controllers.web

import org.vaccineimpact.orderlyweb.ActionContext
import org.vaccineimpact.orderlyweb.controllers.Controller
import org.vaccineimpact.orderlyweb.db.Orderly
import org.vaccineimpact.orderlyweb.db.OrderlyClient
import org.vaccineimpact.orderlyweb.models.Report
import org.vaccineimpact.orderlyweb.viewmodels.AppViewModel

class HomeController(actionContext: ActionContext,
                     private val orderly: OrderlyClient) : Controller(actionContext)
{
    constructor(actionContext: ActionContext) : this(actionContext, Orderly())

    class IndexViewModel(context: ActionContext, val reports: List<Report>) : AppViewModel(context)

    @Template("index.ftl")
    fun index(): IndexViewModel
    {
        return IndexViewModel(context, orderly.getAllReports())
    }
}