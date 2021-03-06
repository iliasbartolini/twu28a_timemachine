package functional.com.thoughtworks.twu;


import com.thoughtworks.twu.constants.URLPaths;

import constants.TestData;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.AssertJUnit;

import java.net.UnknownHostException;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.matchers.JUnitMatchers.containsString;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertNull;
import static org.testng.Assert.assertTrue;
import static org.testng.AssertJUnit.assertNotNull;


public class DatepickerTest extends BaseTest {

    public DatepickerTest() throws UnknownHostException {
        super();
    }

    @Before
    public void setup() throws UnknownHostException {
        super.setUpAndroid();
        webDriver.get(dashboardUrl);
        super.submitCredentials(TestData.validPasswordString);
    }

    @Test
    public void shouldShowErrorWhenBlank(){
        WebElement newTimesheetButton = webDriver.findElement(By.id("new_timesheet"));
        newTimesheetButton.click();
        WebElement submit = webDriver.findElement(By.id("submit"));
        submit.submit();
        WebElement message = webDriver.findElement(By.className("error"));
        assertThat(message.getText(), is(getExpectedErrorMessage("WeekCannotBeUnspecified")));
    }

    @Test
    public void shouldShowErrorWhenDuplicateDate(){
        WebElement newTimesheetButton = webDriver.findElement(By.id("new_timesheet"));
        newTimesheetButton.click();
        chooseParticularSundayAsWeekEndingDate(3);
        WebElement timesheetSubmitButton = webDriver.findElement(By.id("submit"));
        timesheetSubmitButton.click();
        waitForVisibilityOfElementById("new_timesheet").click();
        chooseParticularSundayAsWeekEndingDate(3);
        waitForVisibilityOfElementById("submit").click();
        assertEquals(webDriver.findElement(By.className("colorError")).getText(),getExpectedErrorMessage("DuplicateTimesheetForWeek"));
    }

    @Test
    public void shouldBeReadOnly() {
        WebElement newTimesheetButton = webDriver.findElement(By.id("new_timesheet"));
        newTimesheetButton.click();
        WebElement calender = webDriver.findElement(By.id("weekEndingDate"));
        calender.sendKeys("16-Sep-12");
        assertThat(webDriver.findElement(By.id("weekEndingDate")).getAttribute("value"), is(""));
    }

    @Test
    @Ignore("Not needed any more as same page is being used")
    public void shouldLinkToNewTimesheetWithValidInput() {

        WebElement newTimesheetButton = webDriver.findElement(By.id("new_timesheet"));
        newTimesheetButton.click();
        chooseParticularSundayAsWeekEndingDate(1);
        String selectedWeekEndingDate = webDriver.findElement(By.id("weekEndingDate")).getAttribute("value");
        WebElement dateSubmitButton = webDriver.findElement(By.id("submit"));
        dateSubmitButton.click();
        WebElement weekEndingDisplay = webDriver.findElement(By.id("weekEndingDate"));
        assertEquals(selectedWeekEndingDate, weekEndingDisplay.getText());
    }

    @Test
    @Ignore("Not needed any more as same page is being used")
    public void shouldReturnToDashboardOnCancel() {
        WebElement newTimesheetButton = webDriver.findElement(By.id("new_timesheet"));
        newTimesheetButton.click();

        WebElement cancelButton = webDriver.findElement(By.id("cancel"));
        cancelButton.click();

        assertThat(webDriver.getCurrentUrl(), containsString(URLPaths.DASHBOARD_PATH));
    }

    @Test
    @Ignore("Not needed any more as same page is being used")
    public void shouldNotBeAllowableToManipulateThroughURL() {
        webDriver.get(weekEndingUrl+"8-Oct-12");
        assertFalse(new WebDriverWait(webDriver, 60).until(ExpectedConditions.textToBePresentInElement(By.id("new_timesheet_form"), "8-Oct-12")));
    }

    @Test
    @Ignore("Not needed any more as same page is being used")
    public void duplicateWeekEndingMessageShouldDisappearWhenBlankWeekEndingDateSubmitted() {
        WebElement newTimesheetButton = webDriver.findElement(By.id("new_timesheet"));
        newTimesheetButton.click();
        chooseParticularSundayAsWeekEndingDate(2);
        WebElement timesheetSubmitButton = webDriver.findElement(By.id("submit"));
        timesheetSubmitButton.click();
        waitForVisibilityOfElementById("new_timesheet").click();
        chooseParticularSundayAsWeekEndingDate(2);
        waitForVisibilityOfElementById("submit").click();
        waitForVisibilityOfElementById("submit").click();
        WebElement message = webDriver.findElement(By.className("colorError"));
        assertFalse(message.getText().contains(getExpectedErrorMessage("DuplicateTimesheetForWeek")));
    }

    @Test
    @Ignore("BUG")
    public void pageCrashingOnRefreshAfterDuplicateTimesheetMessage() {
        WebElement newTimesheetButton = webDriver.findElement(By.id("new_timesheet"));
        newTimesheetButton.click();
        chooseParticularSundayAsWeekEndingDate(2);
        WebElement timesheetSubmitButton = webDriver.findElement(By.id("submit"));
        timesheetSubmitButton.click();
        waitForVisibilityOfElementById("new_timesheet").click();
        chooseParticularSundayAsWeekEndingDate(2);
        waitForVisibilityOfElementById("submit").click();
        webDriver.get(submitUrl);
        assertNotNull(waitForVisibilityOfElementById("submit"));
    }
    @After
    public void tearDown(){
        webDriver.close();
    }

}
