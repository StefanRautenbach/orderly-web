package org.vaccineimpact.orderlyweb.tests.database_tests

import com.google.gson.Gson
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.Test
import org.vaccineimpact.orderlyweb.db.JooqContext
import org.vaccineimpact.orderlyweb.db.Tables
import org.vaccineimpact.orderlyweb.db.repositories.OrderlyWebWorkflowRunRepository
import org.vaccineimpact.orderlyweb.models.WorkflowReportWithParams
import org.vaccineimpact.orderlyweb.models.WorkflowRun
import org.vaccineimpact.orderlyweb.test_helpers.CleanDatabaseTests
import org.vaccineimpact.orderlyweb.tests.insertUser
import java.time.Instant

class WorkflowRunRepositoryTests : CleanDatabaseTests()
{
    @Test
    fun `can add workflow run`()
    {
        insertUser("user@email.com", "user.name")

        val now = Instant.now()

        val sut = OrderlyWebWorkflowRunRepository()
        sut.addWorkflowRun(
            WorkflowRun(
                "Interim report",
                "adventurous_aardvark",
                "user@email.com",
                now,
                listOf(
                    WorkflowReportWithParams("reportA", mapOf("param1" to "one", "param2" to "two")),
                    WorkflowReportWithParams("reportB", mapOf("param3" to "three"))
                ),
                mapOf("instanceA" to "pre-staging"),
                "branch1",
                "commit1"
            )
        )
        sut.addWorkflowRun(
            WorkflowRun(
                "Final report",
                "benevolent_badger",
                "user@email.com",
                Instant.now(),
                listOf(
                    WorkflowReportWithParams("reportC", mapOf("param4" to "four", "param5" to "five")),
                    WorkflowReportWithParams("reportD", mapOf("param6" to "six"))
                ),
                mapOf("instanceA" to "post-staging"),
                "branch1",
                "commit1"
            )
        )
        JooqContext().use {
            val result = it.dsl.selectFrom(Tables.ORDERLYWEB_WORKFLOW_RUN).fetch()

            assertThat(result.count()).isEqualTo(2)

            assertThat(result[0][Tables.ORDERLYWEB_WORKFLOW_RUN.ID]).isEqualTo(1)
            assertThat(result[0][Tables.ORDERLYWEB_WORKFLOW_RUN.NAME]).isEqualTo("Interim report")
            assertThat(result[0][Tables.ORDERLYWEB_WORKFLOW_RUN.KEY]).isEqualTo("adventurous_aardvark")
            assertThat(result[0][Tables.ORDERLYWEB_WORKFLOW_RUN.EMAIL]).isEqualTo("user@email.com")
            assertThat(result[0][Tables.ORDERLYWEB_WORKFLOW_RUN.DATE].toInstant()).isEqualTo(now)
            assertThat(result[0][Tables.ORDERLYWEB_WORKFLOW_RUN.REPORTS]).isEqualTo("""[{"name":"reportA","params":{"param1":"one","param2":"two"}},{"name":"reportB","params":{"param3":"three"}}]""")
            assertThat(result[0][Tables.ORDERLYWEB_WORKFLOW_RUN.INSTANCES]).isEqualTo("""{"instanceA":"pre-staging"}""")
            assertThat(result[0][Tables.ORDERLYWEB_WORKFLOW_RUN.GIT_BRANCH]).isEqualTo("branch1")
            assertThat(result[0][Tables.ORDERLYWEB_WORKFLOW_RUN.GIT_COMMIT]).isEqualTo("commit1")

            assertThat(result[1][Tables.ORDERLYWEB_WORKFLOW_RUN.ID]).isEqualTo(2)
        }
    }

    @Test
    fun `cannot add workflow for non-existent user`()
    {
        val sut = OrderlyWebWorkflowRunRepository()
        assertThatThrownBy {
            sut.addWorkflowRun(
                WorkflowRun(
                    "Interim report",
                    "adventurous_aardvark",
                    "user@email.com",
                    Instant.now(),
                    emptyList(),
                    emptyMap()
                )
            )
        }.hasMessageContaining("FOREIGN KEY constraint failed")
    }

    @Test
    fun `cannot add workflow with duplicate key`()
    {
        insertUser("user@email.com", "user.name")

        val sut = OrderlyWebWorkflowRunRepository()
        sut.addWorkflowRun(
            WorkflowRun(
                "Interim report",
                "adventurous_aardvark",
                "user@email.com",
                Instant.now(),
                emptyList(),
                emptyMap()
            )
        )
        assertThatThrownBy {
            sut.addWorkflowRun(
                WorkflowRun(
                    "Interim report",
                    "adventurous_aardvark",
                    "user@email.com",
                    Instant.now(),
                    emptyList(),
                    emptyMap()
                )
            )
        }.hasMessageContaining("UNIQUE constraint failed: orderlyweb_workflow_run.key")
    }

    @Test
    fun `cannot add workflow with duplicate name and timestamp`()
    {
        insertUser("user@email.com", "user.name")

        val now = Instant.now()

        val sut = OrderlyWebWorkflowRunRepository()
        sut.addWorkflowRun(
            WorkflowRun(
                "Interim report",
                "adventurous_aardvark",
                "user@email.com",
                now,
                emptyList(),
                emptyMap()
            )
        )
        assertThatThrownBy {
            sut.addWorkflowRun(
                WorkflowRun(
                    "Interim report",
                    "benevolent_badger",
                    "user@email.com",
                    now,
                    emptyList(),
                    emptyMap()
                )
            )
        }.hasMessageContaining("UNIQUE constraint failed: orderlyweb_workflow_run.name, orderlyweb_workflow_run.date")
    }
}
