package org.vaccineimpact.orderlyweb.tests.database_tests

import org.assertj.core.api.Assertions
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.Test
import org.vaccineimpact.orderlyweb.db.JooqContext
import org.vaccineimpact.orderlyweb.db.repositories.OrderlyAuthorizationRepository
import org.vaccineimpact.orderlyweb.db.Tables.*
import org.vaccineimpact.orderlyweb.errors.DuplicateKeyError
import org.vaccineimpact.orderlyweb.errors.UnknownObjectError
import org.vaccineimpact.orderlyweb.models.Scope
import org.vaccineimpact.orderlyweb.models.permissions.ReifiedPermission
import org.vaccineimpact.orderlyweb.test_helpers.CleanDatabaseTests
import org.vaccineimpact.orderlyweb.test_helpers.insertReport
import org.vaccineimpact.orderlyweb.tests.*

class OrderlyWebAuthorizationRepositoryTests : CleanDatabaseTests()
{
    @Test
    fun `can get permission names sorted alphabetically`()
    {
        val sut = OrderlyAuthorizationRepository()
        val result = sut.getPermissionNames()
        assertThat(result).containsExactly("documents.manage", "documents.read",
                "pinned-reports.manage", "reports.read", "reports.review", "reports.run",
                "tags.manage", "users.manage")
    }

    @Test
    fun `can get empty permission set for user`()
    {
        JooqContext().use {
            insertUser("user@email.com", "user.name")
        }

        val sut = OrderlyAuthorizationRepository()
        val result = sut.getPermissionsForUser("user@email.com")
        assertThat(result).isEmpty()
    }

    @Test
    fun `can get permissions for user`()
    {
        JooqContext().use {
            insertUser("user@email.com", "user.name")

            insertReport("r1", "r1v1")
            insertReport("r2", "r2v1")

            insertUserGroup("Science")
            giveUserGroupMember("Science", "user@email.com")

            giveUserGroupPermission("Science", "reports.review", Scope.Global())
            giveUserGroupPermission("user@email.com", "reports.read", Scope.Global())
            giveUserGroupPermission("user@email.com", "reports.read", Scope.Specific("report", "r1"))
            giveUserGroupPermission("user@email.com", "reports.read", Scope.Specific("report", "r2"))

        }

        val sut = OrderlyAuthorizationRepository()

        val result = sut.getPermissionsForUser("user@email.com")

        assertThat(result)
                .hasSameElementsAs(listOf(ReifiedPermission("reports.review", Scope.Global()).toString(),
                        ReifiedPermission("reports.read", Scope.Global()).toString(),
                        ReifiedPermission("reports.read", Scope.Specific("report", "r1")).toString(),
                        ReifiedPermission("reports.read", Scope.Specific("report", "r2")).toString()))
    }

    @Test
    fun `can get direct permissions for user`()
    {
        JooqContext().use {
            insertUser("user@email.com", "user.name")
            insertReport("r1", "r1v1")
            insertUserGroup("Science")
            giveUserGroupMember("Science", "user@email.com")

            giveUserGroupPermission("user@email.com", "reports.read", Scope.Global())
            giveUserGroupPermission("Science", "reports.review", Scope.Global())
            giveUserGroupPermission("user@email.com", "reports.read", Scope.Specific("report", "r1"))

        }

        val sut = OrderlyAuthorizationRepository()

        val result = sut.getDirectPermissionsForUser("user@email.com")

        assertThat(result)
                .hasSameElementsAs(listOf(ReifiedPermission("reports.read", Scope.Global()),
                        ReifiedPermission("reports.read", Scope.Specific("report", "r1"))))
    }

    @Test
    fun `can get permissions for group`()
    {
        JooqContext().use {
            insertUserGroup("Funders")
            insertReport("fakereport", "v1")
            giveUserGroupPermission("Funders", "reports.read", Scope.Global())
            giveUserGroupPermission("Funders", "reports.review", Scope.Specific("version", "v1"))

            val sut = OrderlyAuthorizationRepository()
            val result = sut.getPermissionsForGroup("Funders")
            assertThat(result)
                    .hasSameElementsAs(listOf(
                            ReifiedPermission("reports.read", Scope.Global()),
                            ReifiedPermission("reports.review", Scope.Specific("version", "v1")))
                    )
        }
    }

    @Test
    fun `can add user group`()
    {
        val sut = OrderlyAuthorizationRepository()
        sut.createUserGroup("testgroup")

        val groups = JooqContext().use {
            it.dsl.selectFrom(ORDERLYWEB_USER_GROUP).fetch()
        }

        Assertions.assertThat(groups.count()).isEqualTo(1)
        Assertions.assertThat(groups.first()[ORDERLYWEB_USER_GROUP.ID]).isEqualTo("testgroup")
    }

    @Test
    fun `can delete user group`()
    {
        val groupName = "Funders"

        var rolePermissionIds: List<Int>
        JooqContext().use {
            insertUserGroup(groupName)
            insertReport("fakereport", "v1")
            giveUserGroupPermission(groupName, "reports.read", Scope.Global())
            giveUserGroupPermission(groupName, "reports.review", Scope.Specific("report", "fakereport"))
            giveUserGroupPermission(groupName, "reports.run", Scope.Specific("version", "v1"))

            insertUser("test@example.com", "Test User")
            giveUserGroupMember(groupName, "test@example.com")

            rolePermissionIds = it.dsl.select(ORDERLYWEB_USER_GROUP_PERMISSION.ID)
                    .from(ORDERLYWEB_USER_GROUP_PERMISSION)
                    .where(ORDERLYWEB_USER_GROUP_PERMISSION.USER_GROUP.eq(groupName))
                    .fetch(ORDERLYWEB_USER_GROUP_PERMISSION.ID)
        }

        val sut = OrderlyAuthorizationRepository()
        sut.deleteUserGroup(groupName)

        JooqContext().use {
            val versionPermCount = it.dsl.selectFrom(ORDERLYWEB_USER_GROUP_VERSION_PERMISSION)
                    .where(ORDERLYWEB_USER_GROUP_VERSION_PERMISSION.ID.`in`(rolePermissionIds))
                    .count()
            assertThat(versionPermCount).isEqualTo(0)

            val reportPermCount = it.dsl.selectFrom(ORDERLYWEB_USER_GROUP_REPORT_PERMISSION)
                    .where(ORDERLYWEB_USER_GROUP_REPORT_PERMISSION.ID.`in`(rolePermissionIds))
                    .count()
            assertThat(reportPermCount).isEqualTo(0)

            val globalPermCount = it.dsl.selectFrom(ORDERLYWEB_USER_GROUP_GLOBAL_PERMISSION)
                    .where(ORDERLYWEB_USER_GROUP_GLOBAL_PERMISSION.ID.`in`(rolePermissionIds))
                    .count()
            assertThat(globalPermCount).isEqualTo(0)

            val basePermCount = it.dsl.selectFrom(ORDERLYWEB_USER_GROUP_PERMISSION)
                    .where(ORDERLYWEB_USER_GROUP_PERMISSION.USER_GROUP.eq(groupName))
                    .count()
            assertThat(basePermCount).isEqualTo(0)

            val memberCount = it.dsl.selectFrom(ORDERLYWEB_USER_GROUP_USER)
                    .where(ORDERLYWEB_USER_GROUP_USER.USER_GROUP.eq(groupName))
                    .count()
            assertThat(memberCount).isEqualTo(0)

            val groupCount = it.dsl.selectFrom(ORDERLYWEB_USER_GROUP)
                    .where(ORDERLYWEB_USER_GROUP.ID.eq(groupName))
                    .count()
            assertThat(groupCount).isEqualTo(0)
        }
    }


    @Test
    fun `cannot add duplicate user groups`()
    {
        val sut = OrderlyAuthorizationRepository()
        sut.createUserGroup("testgroup")

        assertThatThrownBy { sut.createUserGroup("testgroup") }
                .isInstanceOf(DuplicateKeyError::class.java)
                .hasMessageContaining("An object with the id 'testgroup' already exists")
    }

    @Test
    fun `can add permissions to user group`()
    {
        JooqContext().use {
            insertUser("user@email.com", "user.name")
            insertReport("fakereport", "v1")
        }

        val sut = OrderlyAuthorizationRepository()

        sut.ensureUserGroupHasPermission("user@email.com",
                ReifiedPermission("reports.read", Scope.Global()))

        sut.ensureUserGroupHasPermission("user@email.com",
                ReifiedPermission("reports.read", Scope.Specific("report", "fakereport")))

        sut.ensureUserGroupHasPermission("user@email.com",
                ReifiedPermission("reports.read", Scope.Specific("version", "v1")))

        val result = sut.getPermissionsForUser("user@email.com")

        assertThat(result)
                .hasSameElementsAs(listOf(ReifiedPermission("reports.read", Scope.Global()).toString(),
                        ReifiedPermission("reports.read", Scope.Specific("report", "fakereport")).toString(),
                        ReifiedPermission("reports.read", Scope.Specific("version", "v1")).toString()))
    }

    @Test
    fun `ensureUserGroupHasPermission does nothing if user already has permission`()
    {
        JooqContext().use {
            insertUser("user@email.com", "user.name")
            giveUserGroupPermission("user@email.com", "reports.read", Scope.Global())
        }

        val sut = OrderlyAuthorizationRepository()

        sut.ensureUserGroupHasPermission("user@email.com",
                ReifiedPermission("reports.read", Scope.Global()))

        val result = sut.getPermissionsForUser("user@email.com")

        assertThat(result)
                .hasSameElementsAs(listOf(ReifiedPermission("reports.read", Scope.Global()).toString()))
    }

    @Test
    fun `ensureUserGroupHasPermission throws UnknownObjectError if permission does not exist`()
    {
        JooqContext().use {
            insertUser("user@email.com", "user.name")
        }

        val sut = OrderlyAuthorizationRepository()

        assertThatThrownBy {
            sut.ensureUserGroupHasPermission("user@email.com",
                    ReifiedPermission("nonexistent.permission", Scope.Global()))
        }.isInstanceOf(UnknownObjectError::class.java)
                .hasMessageContaining("Unknown permission : 'nonexistent.permission'")
    }

    @Test
    fun `ensureUserGroupHasPermission throws UnknownObjectError if group does not exist`()
    {
        val sut = OrderlyAuthorizationRepository()

        assertThatThrownBy {
            sut.ensureUserGroupHasPermission("nonsense",
                    ReifiedPermission("reports.read", Scope.Global()))
        }.isInstanceOf(UnknownObjectError::class.java)
                .hasMessageContaining("Unknown user-group : 'nonsense'")
    }

    @Test
    fun `can remove permissions from user group`()
    {
        JooqContext().use {
            insertUser("user@email.com", "user.name")
            insertReport("fakereport", "v1")
            insertReport("fakereport2", "v2")
        }

        val sut = OrderlyAuthorizationRepository()

        //Add permissions - as tested above
        sut.ensureUserGroupHasPermission("user@email.com",
                ReifiedPermission("reports.review", Scope.Global()))

        sut.ensureUserGroupHasPermission("user@email.com",
                ReifiedPermission("reports.read", Scope.Global()))

        sut.ensureUserGroupHasPermission("user@email.com",
                ReifiedPermission("reports.read", Scope.Specific("report", "fakereport")))

        sut.ensureUserGroupHasPermission("user@email.com",
                ReifiedPermission("reports.read", Scope.Specific("version", "v1")))

        sut.ensureUserGroupHasPermission("user@email.com",
                ReifiedPermission("reports.read", Scope.Specific("version", "v2")))

        //..then remove some
        sut.ensureUserGroupDoesNotHavePermission("user@email.com",
                ReifiedPermission("reports.review", Scope.Global()))

        sut.ensureUserGroupDoesNotHavePermission("user@email.com",
                ReifiedPermission("reports.read", Scope.Specific("report", "fakereport")))

        sut.ensureUserGroupDoesNotHavePermission("user@email.com",
                ReifiedPermission("reports.read", Scope.Specific("version", "v1")))


        val result = sut.getPermissionsForUser("user@email.com")

        assertThat(result)
                .hasSameElementsAs(listOf(ReifiedPermission("reports.read", Scope.Global()).toString(),
                        ReifiedPermission("reports.read", Scope.Specific("version", "v2")).toString()))
    }

    @Test
    fun `ensureUserGroupDoesNotHavePermission does nothing if user does not already have permission`()
    {
        JooqContext().use {
            insertUser("user@email.com", "user.name")
            giveUserGroupPermission("user@email.com", "reports.read", Scope.Global())
        }

        val sut = OrderlyAuthorizationRepository()

        sut.ensureUserGroupHasPermission("user@email.com",
                ReifiedPermission("reports.read", Scope.Global()))

        sut.ensureUserGroupDoesNotHavePermission("user@email.com",
                ReifiedPermission("reports.review", Scope.Global()))

        val result = sut.getPermissionsForUser("user@email.com")

        assertThat(result)
                .hasSameElementsAs(listOf(ReifiedPermission("reports.read", Scope.Global()).toString()))
    }

    @Test
    fun `ensureUserGroupDoesNotHavePermission throws UnknownObjectError if permission does not exist`()
    {
        JooqContext().use {
            insertUser("user@email.com", "user.name")
        }

        val sut = OrderlyAuthorizationRepository()

        assertThatThrownBy {
            sut.ensureUserGroupDoesNotHavePermission("user@email.com",
                    ReifiedPermission("nonexistent.permission", Scope.Global()))
        }.isInstanceOf(UnknownObjectError::class.java)
                .hasMessageContaining("Unknown permission : 'nonexistent.permission'")
    }

    @Test
    fun `ensureUserGroupDoesNotHavePermission throws UnknownObjectError if group does not exist`()
    {
        val sut = OrderlyAuthorizationRepository()

        assertThatThrownBy {
            sut.ensureUserGroupDoesNotHavePermission("nonsense",
                    ReifiedPermission("reports.read", Scope.Global()))
        }.isInstanceOf(UnknownObjectError::class.java)
                .hasMessageContaining("Unknown user-group : 'nonsense'")
    }

    @Test
    fun `ensureUserGroupHasPermission throws UnknownObjectError if scope prefix does not exist`()
    {
        JooqContext().use {
            insertUser("user@email.com", "user.name")
        }

        val sut = OrderlyAuthorizationRepository()

        assertThatThrownBy {
            sut.ensureUserGroupHasPermission("user@email.com",
                    ReifiedPermission("reports.read", Scope.Specific("nonsense", "r1")))
        }.isInstanceOf(UnknownObjectError::class.java)
                .hasMessageContaining("Unknown permission-scope : 'nonsense'")
    }

    @Test
    fun `can add user to group`()
    {
        val sut = OrderlyAuthorizationRepository()
        sut.createUserGroup("somegroup")
        JooqContext().use {
            it.dsl.insertInto(ORDERLYWEB_USER)
                    .set(ORDERLYWEB_USER.EMAIL, "user@email.com")
                    .set(ORDERLYWEB_USER.USER_SOURCE, "GitHub")
                    .set(ORDERLYWEB_USER.USERNAME, "user.name")
                    .execute()
        }
        sut.ensureGroupHasMember("somegroup", "user@email.com")

        val user = JooqContext().use {
            it.dsl.selectFrom(ORDERLYWEB_USER_GROUP_USER)
                    .where(ORDERLYWEB_USER_GROUP_USER.USER_GROUP.eq("somegroup"))
                    .single()
        }

        assertThat(user[ORDERLYWEB_USER_GROUP_USER.EMAIL]).isEqualTo("user@email.com")
    }

    @Test
    fun `ensureGroupHasMember does nothing if user already in group`()
    {
        val sut = OrderlyAuthorizationRepository()
        sut.createUserGroup("somegroup")
        JooqContext().use {
            it.dsl.insertInto(ORDERLYWEB_USER)
                    .set(ORDERLYWEB_USER.EMAIL, "user@email.com")
                    .set(ORDERLYWEB_USER.USER_SOURCE, "GitHub")
                    .set(ORDERLYWEB_USER.USERNAME, "user.name")
                    .execute()
        }

        sut.ensureGroupHasMember("somegroup", "user@email.com")
        sut.ensureGroupHasMember("somegroup", "user@email.com")

        val user = JooqContext().use {
            it.dsl.selectFrom(ORDERLYWEB_USER_GROUP_USER)
                    .where(ORDERLYWEB_USER_GROUP_USER.USER_GROUP.eq("somegroup"))
                    .single()
        }

        assertThat(user[ORDERLYWEB_USER_GROUP_USER.EMAIL]).isEqualTo("user@email.com")
    }

    @Test
    fun `ensureUserGroupDoesNotHaveMember removes user from group`()
    {
        JooqContext().use {
            insertUser("user@email.com", "user.name")
            insertUserGroup("some-group")
            giveUserGroupMember("some-group", "user@email.com")
        }

        val sut = OrderlyAuthorizationRepository()
        sut.ensureGroupDoesNotHaveMember("some-group", "user@email.com")

        val userGroupUser = JooqContext().use {
            it.dsl.selectFrom(ORDERLYWEB_USER_GROUP_USER)
                    .where(ORDERLYWEB_USER_GROUP_USER.USER_GROUP.eq("some-group")
                            .and(ORDERLYWEB_USER_GROUP_USER.EMAIL.eq("user@email.com")))
                    .fetch()
        }
        assertThat(userGroupUser.count()).isEqualTo(0)
    }

    @Test
    fun `ensureGroupHasMember throws UnknownObjectError if group does not exist`()
    {
        val sut = OrderlyAuthorizationRepository()

        assertThatThrownBy {
            sut.ensureGroupHasMember("nonsense", "user@email.com")
        }.isInstanceOf(UnknownObjectError::class.java)
                .hasMessageContaining("Unknown user-group : 'nonsense'")
    }

    @Test
    fun `ensureGroupHasMember throws UnknownObjectError if user does not exist`()
    {
        val sut = OrderlyAuthorizationRepository()
        sut.createUserGroup("testgroup")
        assertThatThrownBy {
            sut.ensureGroupHasMember("testgroup", "user@email.com")
        }.isInstanceOf(UnknownObjectError::class.java)
                .hasMessageContaining("Unknown user : 'user@email.com'")
    }

}