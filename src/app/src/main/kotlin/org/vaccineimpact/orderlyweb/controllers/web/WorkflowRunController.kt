package org.vaccineimpact.orderlyweb.controllers.web

import org.vaccineimpact.orderlyweb.ActionContext
import org.vaccineimpact.orderlyweb.controllers.Controller
import org.vaccineimpact.orderlyweb.db.repositories.OrderlyWebWorkflowRunRepository
import org.vaccineimpact.orderlyweb.db.repositories.WorkflowRunRepository
import org.vaccineimpact.orderlyweb.models.WorkflowRunSummary
import org.vaccineimpact.orderlyweb.viewmodels.WorkflowRunViewModel

class WorkflowRunController(
    context: ActionContext,
    private val workflowRunRepository: WorkflowRunRepository
) : Controller(context)
{
    constructor(context: ActionContext) : this(
        context,
        OrderlyWebWorkflowRunRepository()
    )

    @Template("run-workflow-page.ftl")
    fun getRunWorkflow(): WorkflowRunViewModel
    {
        return WorkflowRunViewModel(context)
    }

    fun getWorkflowRunSummaries(): List<WorkflowRunSummary>
    {
        return workflowRunRepository.getWorkflowRunSummaries(
            context.queryParams("email"),
            context.queryParams("namePrefix")
        )
    }
}