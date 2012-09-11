package functional.com.thoughtworks.twu;

import com.thoughtworks.twu.constants.URLPaths;
import constants.TestData;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import java.net.UnknownHostException;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;
import static org.junit.matchers.JUnitMatchers.containsString;

public class LoginActivitiesTest extends BaseTest {

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
        super.submitCredentials(TestData.validPasswordString);
        assertNotNull(webDriver.findElement(By.name("add")));
    }

    @Test
    public void shouldBeAbleToRedirectToGivenURLAfterLoginAfterOneFailedLogin() throws Exception {
        webDriver.get(dashboardUrl);
        submitCredentials(TestData.invalidPasswordString);
        submitCredentials(TestData.validPasswordString);
        assertThat(webDriver.getCurrentUrl(), containsString(URLPaths.DASHBOARD_PATH));
    }

    @Test
    public void shouldBeAbleToRedirectToGivenURLAfterLogin() throws Exception {
        webDriver.get(dashboardUrl);
        assertThat(webDriver.getCurrentUrl(), containsString("https://castest.thoughtworks.com/cas/login?"));
        submitCredentials(TestData.validPasswordString);
        assertThat(webDriver.getCurrentUrl(), containsString(URLPaths.DASHBOARD_PATH));
    }

    @After
    public void tearDown() {
        webDriver.close();
    }

}
