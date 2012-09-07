package functional.com.thoughtworks.twu;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.net.UnknownHostException;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.junit.matchers.JUnitMatchers.containsString;

public class DatepickerTest extends BaseTest {
    private String validPasswordString = "Th0ughtW0rks@12";

    public DatepickerTest() throws UnknownHostException {
        super();
    }

    @Before

    public void setup() throws UnknownHostException {
        super.setUpAndroid();
        webDriver.get(datePickerUrl);
        super.submitCredentials(validPasswordString);
    }
    @Test
    public void shouldShowErrorWhenBlank(){
        WebElement submit = webDriver.findElement(By.id("submit"));
        submit.submit();
        WebElement message = webDriver.findElement(By.xpath("//label[@class='error']"));
        assertThat(message.getText(), is("Week ending date is required."));
    }

    @Test
    @Ignore("Link to put back date on timesheet pending")
    public void shouldLinkToNewTimesheetWithValidInput() {

        WebElement calendar = webDriver.findElement(By.id("wecal"));
        WebElement submit = webDriver.findElement(By.id("submit"));
        submit.submit();
        assertThat(webDriver.getCurrentUrl(), containsString(newTimesheetPath));
    }
    @After
    public void tearDown(){
        webDriver.close();
    }

}
