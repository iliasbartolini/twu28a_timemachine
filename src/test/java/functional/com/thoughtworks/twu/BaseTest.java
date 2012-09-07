package functional.com.thoughtworks.twu;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;

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
    protected String dashboardPagePath = ":9093/timemachine";
    protected String datePickerPath = ":9093/timemachine/timesheet/datepicker";
    protected String newTimesheetPath = ":9093/timemachine/timesheet/newtimesheet";
    protected String timeRecordPath = ":9093/timemachine/timesheet/timerecord";
    protected String searchActivityPath = ":9093/timemachine/timesheet/search_activity";
    public BaseTest() throws UnknownHostException {
        String hostName = InetAddress.getLocalHost().getHostName();
        dashboardUrl = hostName +dashboardPagePath;
        datePickerUrl = hostName + datePickerPath;
        newTimesheetUrl = hostName + newTimesheetPath;
        timeRecordUrl = hostName + timeRecordPath;
        searchActivityUrl = hostName + searchActivityPath;
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
    public void setUpAndroid() {
        FirefoxProfile firefoxProfile = new FirefoxProfile();
        String userAgent = "Android 4.0.4 - Opera 12.00";
        firefoxProfile.setPreference("general.useragent.override", userAgent);
        webDriver = new FirefoxDriver(firefoxProfile);
        webDriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }


}
