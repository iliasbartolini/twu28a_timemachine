package functional.com.thoughtworks.twu;

import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;

public class BaseTest {


    protected WebDriver webDriver;
    protected String userNameString = "test.twu";

    protected void submitCredentials(String passwordString) {
        WebElement username = webDriver.findElement(By.id("username"));
        username.clear();
        username.sendKeys(userNameString);

        WebElement password = webDriver.findElement(By.id("password"));
        password.sendKeys(passwordString);

        WebElement submitButton = webDriver.findElement(By.className("btn-submit"));
        submitButton.submit();
    }


    public void setUpAndroid() {
        FirefoxProfile firefoxProfile = new FirefoxProfile();
        String userAgent = "Android 4.0.4 - Opera 12.00";
        firefoxProfile.setPreference("general.useragent.override", userAgent);
        webDriver = new FirefoxDriver(firefoxProfile);
    }



}