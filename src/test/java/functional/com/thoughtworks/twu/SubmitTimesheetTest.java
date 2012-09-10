package functional.com.thoughtworks.twu;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import static org.junit.Assert.assertEquals;
import java.net.UnknownHostException;

public class SubmitTimesheetTest extends BaseTest {
    private String validPasswordString = "Th0ughtW0rks@12";

    public SubmitTimesheetTest() throws UnknownHostException {
        super();
    }

    @Before
    public void setup() throws Exception {
        super.setUpAndroid();
        webDriver.get(dashboardUrl);
        super.submitCredentials(validPasswordString);
    }
    @Test
    @Ignore("Functionality Pending")
    public void shouldBeAbleToSubmitTimesheet() {
        WebElement newTimesheetButton = webDriver.findElement(By.id("new_timesheet"));
        newTimesheetButton.click();
        WebElement openDatepickerButton = webDriver.findElement(By.xpath("//a[@title='Open Date Picker']"));
        openDatepickerButton.click();
        WebElement sundayButton = webDriver.findElement(By.className("ui-btn-up-e"));
        sundayButton.click();

        String selectedWeekEndingDate = webDriver.findElement(By.id("wecal")).getAttribute("value");

        WebElement submitButton = webDriver.findElement(By.id("submit"));
        submitButton.click();

        WebElement weekEndingDisplay = webDriver.findElement(By.id("weekEndingDate"));
        assertEquals(selectedWeekEndingDate, weekEndingDisplay.getText());
    }
    @After
    public void teardown() {
        webDriver.close();
    }
}
