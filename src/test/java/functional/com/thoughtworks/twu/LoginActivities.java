package functional.com.thoughtworks.twu;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;

import static org.junit.Assert.assertNotNull;

public class LoginActivities {
    private WebDriver webDriver;
    private String url = "localhost:9093/timemachine";

    @Before
    public void setUpAndroid() {
        FirefoxProfile firefoxProfile = new FirefoxProfile();
        String userAgent = "Android 4.0.4 - Opera 12.00";
        firefoxProfile.setPreference("general.useragent.override", userAgent );
        webDriver = new FirefoxDriver(firefoxProfile);
    }

    @Test
    public void loginWithCAS() {
        String userNameString = "test.twu";
        String passwordString = "Th0ughtW0rks@12";

        webDriver.get(url);

        WebElement username = webDriver.findElement(By.id("username"));
        username.sendKeys(userNameString);

        WebElement password  = webDriver.findElement(By.id("password"));
        password.sendKeys(passwordString);

        WebElement submitButton = webDriver.findElement(By.className("btn-submit"));
        submitButton.submit();

        assertNotNull(webDriver.findElement(By.name("add")));

    }
    @After
    public void tearDown() {
        webDriver.close();
    }

}
