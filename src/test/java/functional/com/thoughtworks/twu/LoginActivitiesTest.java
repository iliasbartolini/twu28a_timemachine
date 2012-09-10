package functional.com.thoughtworks.twu;

import com.thoughtworks.twu.constants.URLPaths;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import java.net.UnknownHostException;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;
import static org.junit.matchers.JUnitMatchers.containsString;

public class LoginActivitiesTest extends BaseTest {
    private String invalidPasswordString = "abcd";
    private String validPasswordString = "Th0ughtW0rks@12";

    public LoginActivitiesTest() throws UnknownHostException {
        super();
    }

    @Before
    public void init() throws UnknownHostException {
        super.setUpAndroid();
    }

    @Test
    public void shouldBeAbleToLoginWithCAS() throws Exception {
        webDriver.get(dashboardUrl);
        System.out.println(webDriver.getCurrentUrl());
        super.submitCredentials(validPasswordString);
        assertNotNull(webDriver.findElement(By.name("add")));
    }

    @Test
    public void shouldBeAbleToRedirectToGivenURLAfterLoginAfterOneFailedLogin() throws Exception {
        webDriver.get(newTimesheetUrl);
        assertThat(webDriver.getCurrentUrl(), containsString("https://castest.thoughtworks.com/cas/login?"));
        submitCredentials(invalidPasswordString);
        assertNotNull(webDriver.findElement(By.id("msg")));
        submitCredentials(validPasswordString);
        assertThat(webDriver.getCurrentUrl(), containsString(URLPaths.NEW_TIMESHEET_PATH));
    }

    @Test
    public void shouldBeAbleToRedirectToGivenURLAfterLogin() throws Exception {
        webDriver.get(newTimesheetUrl);
        assertThat(webDriver.getCurrentUrl(), containsString("https://castest.thoughtworks.com/cas/login?"));
        submitCredentials(validPasswordString);
        assertThat(webDriver.getCurrentUrl(), containsString(URLPaths.NEW_TIMESHEET_PATH));
    }

    @After
    public void tearDown() {
        webDriver.close();
    }

}
