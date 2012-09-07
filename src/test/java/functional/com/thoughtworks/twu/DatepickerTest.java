package functional.com.thoughtworks.twu;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.net.InetAddress;
import java.net.UnknownHostException;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.junit.matchers.JUnitMatchers.containsString;

public class DatepickerTest extends BaseTest {
    private String datePickerUrl;
    private String validPasswordString = "Th0ughtW0rks@12";

    @Before

    public void setup() throws UnknownHostException {
        super.setUpAndroid();
        datePickerUrl = InetAddress.getLocalHost().getHostName() + ":9093/timemachine/timesheet/datepicker";
        webDriver.get(datePickerUrl);
        super.submitCredentials(validPasswordString);

    }


    @Test
    @Ignore
    public void shouldShowErrorWhenBlank(){

        WebElement submit = webDriver.findElement(By.id("submit"));
        submit.submit();
        WebElement message = webDriver.findElement(By.xpath("//label[@class='error']"));

        assertThat(message.getText(), is("Week ending date is required."));
    }

    @Test
    @Ignore
    public void shouldLinkToNewTimesheetWithValidInput() {

        WebElement calendar = webDriver.findElement(By.id("wecal"));


        WebElement submit = webDriver.findElement(By.id("submit"));
        submit.submit();

        assertThat(webDriver.getCurrentUrl(), containsString("/timemachine/timesheet/newtimesheet"));


    }

//    @After
//    public void tearDown(){
//        webDriver.close();
//    }

}
