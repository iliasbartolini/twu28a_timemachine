package functional.com.thoughtworks.twu;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;

import java.net.InetAddress;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;
import static org.junit.matchers.JUnitMatchers.containsString;

public class LoginActivities extends BaseTest {
    private String invalidPasswordString = "abcd";
    private String validPasswordString = "Th0ughtW0rks@12";


    @Before
    public void init() {
        super.setUpAndroid();
}

    @Test
    public void shouldBeAbleToLoginWithCAS() throws Exception {
        String url = InetAddress.getLocalHost().getHostName() + ":9093/timemachine";
        webDriver.get(url);

        super.submitCredentials(validPasswordString);

        assertNotNull(webDriver.findElement(By.name("add")));

    }

    @Test
    public void shouldBeAbleToRedirectToGivenURLAfterLoginAfterOneFailedLogin() throws Exception {
        String path = ":9093/timemachine/timesheet/new";
        String url = InetAddress.getLocalHost().getHostName() + path;
        webDriver.get(url);

        assertThat(webDriver.getCurrentUrl(), containsString("https://castest.thoughtworks.com/cas/login?"));

        submitCredentials(invalidPasswordString);

        assertNotNull(webDriver.findElement(By.id("msg")));

        submitCredentials(validPasswordString);

        assertThat(webDriver.getCurrentUrl(), containsString(path));
    }

    @Test
    public void shouldBeAbleToRedirectToGivenURLAfterLogin() throws Exception {
        String path = ":9093/timemachine/timesheet/new";
        String url = InetAddress.getLocalHost().getHostName() + path;
        webDriver.get(url);

        assertThat(webDriver.getCurrentUrl(), containsString("https://castest.thoughtworks.com/cas/login?"));

        submitCredentials(validPasswordString);

        assertThat(webDriver.getCurrentUrl(), containsString(path));
    }

    @After
    public void tearDown() {
        webDriver.close();
    }

}
