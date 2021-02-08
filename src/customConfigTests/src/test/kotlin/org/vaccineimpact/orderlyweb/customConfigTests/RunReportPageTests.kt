package org.vaccineimpact.orderlyweb.customConfigTests

import org.junit.Test
import org.junit.Before
import org.openqa.selenium.By
import org.openqa.selenium.support.ui.ExpectedConditions
import org.assertj.core.api.Assertions.assertThat
import org.junit.Assert
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.ui.Select
import org.vaccineimpact.orderlyweb.db.JooqContext
import org.vaccineimpact.orderlyweb.test_helpers.giveUserGroupGlobalPermission
import org.vaccineimpact.orderlyweb.test_helpers.insertUserAndGroup

class RunReportPageTests : SeleniumTest()
{
    @Before
    fun setUp()
    {
        JooqContext().use {
            insertUserAndGroup(it, "test.user@example.com")
            giveUserGroupGlobalPermission(it, "test.user@example.com", "reports.run")
        }

        startApp("auth.provider=montagu")

        loginWithMontagu()

        val url = RequestHelper.webBaseUrl + "/run-report/"
        driver.get(url)
    }

    @Test
    fun `can view run tab`()
    {
        val tab = driver.findElement(By.id("run-tab"))

        assertThat(tab.findElement(By.tagName("h2")).text).isEqualTo("Run a report")
        val select = Select(tab.findElement(By.tagName("select")))
        assertThat(select.firstSelectedOption.text).isEqualTo("master")
    }

    @Test
    fun `can view git commits`()
    {
        val commitsSelect = Select(driver.findElement(By.id("git-commit")))
        assertThat(commitsSelect.options.size).isEqualTo(2)
        assertThat(commitsSelect.options).allMatch { it.text.contains(Regex("[0-9a-f]{7}")) }
    }

    @Test
    fun `can view and select reports`()
    {
        val typeahead = driver.findElement(By.id("report"))
        assertThat(typeahead.findElements(By.tagName("a")).size).isEqualTo(2)
        val input = typeahead.findElement(By.tagName("input"))
        input.sendKeys("min")
        val matches = typeahead.findElements(By.tagName("a"))
        assertThat(matches.size).isEqualTo(1)
        assertThat(matches[0].text).startsWith("minimal")
    }

    @Test
    fun `can run a report and check status`()
    {
        val typeahead = driver.findElement(By.id("report"))
        val input = typeahead.findElement(By.tagName("input"))
        input.sendKeys("min")
        val matches = typeahead.findElements(By.tagName("a"))
        matches[0].click()

        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("run-form-group")))

        val button = driver.findElement(By.cssSelector("#run-form-group button"))
        button.click()

        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("run-report-status")))
        assertThat(driver.findElement(By.id("run-report-status")).text).startsWith("Run started")

        driver.findElement(By.cssSelector("#run-report-status a")).click()
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.id("run-report-status"), "Running status:"))
    }

    @Test
    fun `can view logs tab`()
    {
        driver.findElement(By.id("logs-link")).click()

        val tab = driver.findElement(By.id("logs-tab"))
        wait.until(ExpectedConditions.attributeToBe(tab,"display", "block"))

        assertThat(tab.findElement(By.tagName("h2")).text).isEqualTo("Report logs")
        assertThat(tab.findElement(By.tagName("p")).text).isEqualTo("Report logs coming soon!")
    }

    @Test
    fun `can render parameters text`()
    {
        val gitBranch = Select(driver.findElement(By.id("git-branch")))
        gitBranch.selectByVisibleText("other")

        val typeahead = driver.findElement(By.id("report"))
        val input = typeahead.findElement(By.tagName("input"))
        input.sendKeys("other")

        val parameters = driver.findElement(By.id("parameters"))
        val paramInput = parameters.findElements(By.tagName("input"))
        paramInput[0].sendKeys("param value")
        assertThat(paramInput[0].text).isEqualTo("param value")

        val paramLabel = parameters.findElements(By.tagName("label"))
        assertThat(paramLabel.size).isEqualTo(2)
        assertThat(paramLabel[0].text).isEqualTo("Parameters")
        assertThat(paramLabel[1].text).isEqualTo("nmin")
    }
}
