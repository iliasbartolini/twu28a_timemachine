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

import static org.testng.Assert.assertTrue;

public class SubmitTimesheetTest extends BaseTest {

    public SubmitTimesheetTest() throws UnknownHostException {
        super();
    }

    @Before
    public void setup() throws Exception {
        super.setUpAndroid();
        webDriver.get(dashboardUrl);
        super.submitCredentials(TestData.validPasswordString);
    }


    @Test
    @Ignore("Functionality not yet implemented")
    public void shouldBeAbleToSubmitTimesheet() {
        WebElement newTimesheetButton = webDriver.findElement(By.id("new_timesheet"));
        newTimesheetButton.click();
        chooseParticularSundayAsWeekEndingDate(1);

        String selectedWeekEndingDate = webDriver.findElement(By.id("weekEndingDate")).getAttribute("value");
        WebElement dateSubmitButton = webDriver.findElement(By.id("submit"));
        dateSubmitButton.click();

        WebElement timesheetSubmitButton = webDriver.findElement(By.id("submit"));
        timesheetSubmitButton.click();

        List<WebElement> submittedTimesheets = webDriver.findElements(By.id("timesheet_list"));

        boolean containsDate = false;
        for(WebElement element : submittedTimesheets) {
            if(element.getText().equals(selectedWeekEndingDate)) {
                containsDate = true;
                break;
            }
        }
        assertTrue(containsDate);
    }
    @After
    public void teardown() {
        webDriver.close();
    }
}
