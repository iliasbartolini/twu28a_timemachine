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

public class LoginActivities {
    private WebDriver webDriver;
    private String userNameString = "test.twu";
    private String passwordString = "Th0ughtW0rks@12";

    @Before
    public void setUpAndroid() {
        FirefoxProfile firefoxProfile = new FirefoxProfile();
        String userAgent = "Android 4.0.4 - Opera 12.00";
        firefoxProfile.setPreference("general.useragent.override", userAgent );
        webDriver = new FirefoxDriver();

    }

    @Test
    public void shouldBeAbleToLoginWithCAS() throws Exception {
        String url = InetAddress.getLocalHost().getHostName() + ":9093/timemachine";
        webDriver.get(url);

        submitCredentials();

        assertNotNull(webDriver.findElement(By.name("add")));

    }

    private void submitCredentials() {
        WebElement username = webDriver.findElement(By.id("username"));
        username.sendKeys(userNameString);

        WebElement password  = webDriver.findElement(By.id("password"));
        password.sendKeys(passwordString);

        WebElement submitButton = webDriver.findElement(By.className("btn-submit"));
        submitButton.submit();
    }

    @Test
    public void shouldBeAbleToRedirectToGivenURLAfterLogin() throws Exception {
        String path = ":9093/timemachine/timesheet/new";
        String url = InetAddress.getLocalHost().getHostName() + path;
        webDriver.get(url);

        assertThat(webDriver.getCurrentUrl(), containsString("https://castest.thoughtworks.com/cas/login?"));

        submitCredentials();

        assertThat(webDriver.getCurrentUrl(), containsString(path));
    }

    @After
    public void tearDown() {
        webDriver.close();
    }

}
