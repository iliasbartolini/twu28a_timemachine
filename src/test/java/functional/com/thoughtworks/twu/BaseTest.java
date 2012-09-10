package functional.com.thoughtworks.twu;

import com.thoughtworks.twu.constants.URLPaths;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.concurrent.TimeUnit;

public class BaseTest {


    protected WebDriver webDriver;
    protected String userNameString = "test.twu";
    protected String dashboardUrl;
    protected String datePickerUrl;
    protected String newTimesheetUrl;
    protected String timeRecordUrl;
    protected String searchActivityUrl;


    public BaseTest() throws UnknownHostException {
        String hostName = InetAddress.getLocalHost().getHostName();
        dashboardUrl = hostName + URLPaths.DASHBOARD_PATH;
        datePickerUrl = hostName + URLPaths.DATEPICKER_PATH;
        newTimesheetUrl = hostName + URLPaths.NEW_TIMESHEET_PATH;
        timeRecordUrl = hostName + URLPaths.TIME_RECORD_PATH;
        searchActivityUrl = hostName + URLPaths.SEARCH_ACTIVITY_PATH;
    }

    protected void submitCredentials(String passwordString) {
        WebElement username = webDriver.findElement(By.id("username"));
        username.clear();
        username.sendKeys(userNameString);
        WebElement password = webDriver.findElement(By.id("password"));
        password.sendKeys(passwordString);
        WebElement submitButton = webDriver.findElement(By.className("btn-submit"));
        submitButton.submit();
    }
    protected WebElement waitForVisibilityOfElementById(String elementid) throws TimeoutException {
        return (new WebDriverWait(webDriver, 10).until(ExpectedConditions.visibilityOfElementLocated(By.id(elementid))));
    }
    public void setUpAndroid() {
        FirefoxProfile firefoxProfile = new FirefoxProfile();
        String userAgent = "Android 4.0.4 - Opera 12.00";
        firefoxProfile.setPreference("general.useragent.override", userAgent);
        webDriver = new FirefoxDriver(firefoxProfile);
        webDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }


}
