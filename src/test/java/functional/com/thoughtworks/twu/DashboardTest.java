package functional.com.thoughtworks.twu;

import constants.TestData;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.net.UnknownHostException;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class DashboardTest extends BaseTest {

    public DashboardTest() throws UnknownHostException {
        super();
    }

    @Before
    public void setup() throws Exception {
        super.setUpAndroid();
        webDriver.get(dashboardUrl);
        super.submitCredentials(TestData.validPasswordString);
    }

    @Test
    public void shouldJumpToDatepickerPage() throws Exception {
        webDriver.get(dashboardUrl);
        WebElement datePickerLink = webDriver.findElement(By.id("new_timesheet"));

        datePickerLink.click();
        assertNotNull(waitForVisibilityOfElementById("weekEndingDate"));
    }

    @Test
    public void shouldDisplayNameInHeader() throws Exception {
        webDriver.get(dashboardUrl);
        WebElement header = webDriver.findElement(By.id("header"));
        assertEquals("Welcome Tester", header.getText());
    }
    @Test
    @Ignore
    public void shouldSortTimesheetsInReverseChronologicalOrderByWeekendingDate() {
        WebElement newTimesheetButton = webDriver.findElement(By.id("new_timesheet"));
        newTimesheetButton.click();
        WebElement openDatepickerButton = webDriver.findElement(By.xpath("//a[@title='Open Date Picker']"));
        openDatepickerButton.click();
        List<WebElement> sundayButton = webDriver.findElements(By.className("ui-btn-up-e"));
        System.out.print(sundayButton.size());
        sundayButton.get(0).click();
        WebElement dateSubmitButton = webDriver.findElement(By.id("submit"));
        dateSubmitButton.click();
        WebElement timesheetSubmitButton = webDriver.findElement(By.id("submit"));
        timesheetSubmitButton.click();

        newTimesheetButton.click();
        openDatepickerButton.click();
        sundayButton.get(1).click();
        dateSubmitButton.click();
    }
    @After
    public void tearDown() {
        webDriver.close();
    }
}
