package functional.com.thoughtworks.twu;

import com.thoughtworks.twu.constants.URLPaths;
import com.thoughtworks.twu.domain.Message;
import com.thoughtworks.twu.service.MessageService;
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
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class BaseTest {


    protected WebDriver webDriver;
    protected String userNameString = "test.twu";
    protected String basePath = ":9093/timemachine";
    protected String dashboardUrl;
    protected String datePickerUrl;
    protected String newTimesheetUrl;
    protected String timeRecordUrl;
    protected String searchActivityUrl;
    protected Map<String, String> expectedMessages = new HashMap<String, String>();

    public BaseTest() throws UnknownHostException {
        String hostName = InetAddress.getLocalHost().getHostName();
        dashboardUrl = hostName + basePath + URLPaths.DASHBOARD_PATH;
        datePickerUrl = hostName + basePath + URLPaths.DATEPICKER_PATH;
        newTimesheetUrl = hostName + basePath + URLPaths.NEW_TIMESHEET_PATH;
        timeRecordUrl = hostName + basePath + URLPaths.TIME_RECORD_PATH;
        searchActivityUrl = hostName + basePath + URLPaths.SEARCH_ACTIVITY_PATH;

        expectedMessages.put("UserNamePasswordCannotBeBlank","Username is a required field.  Password is a required field.");
        expectedMessages.put("UserNamePasswordMismatch","The credentials you provided cannot be determined to be authentic.");
        expectedMessages.put("NoExistingTimesheets","You don't have any saved timesheets.  ");
        expectedMessages.put("Alteast2CharsForSearch","Type in more than two characters.");
        expectedMessages.put("NoMatchingActivity","No matching activity found.");
        expectedMessages.put("TimesheetnameBlank","Name field cannot be left blank.");
        expectedMessages.put("DuplicateFavTimesheet","Duplicate name. Please try another name.");
        expectedMessages.put("CountryCannotBeUnspecified","Country is required.");
        expectedMessages.put("StateCannotBeUnspecified","State is required.");
        expectedMessages.put("ActivityCannotBeUnspecified","Activity is required.");
        expectedMessages.put("WeekCannotBeUnspecified","Week ending date is required.");
        expectedMessages.put("DuplicateTimesheetForWeek","Week ending date is already associated with a Time Report.");
        expectedMessages.put("TaskCommentCannotBeUnspecified","Task Comment is required.");
        expectedMessages.put("HoursLessThan40","Your total billed hours for the week are less than 40. Do you want to continue submitting this timesheet?");
        expectedMessages.put("PublicHolidayConfirmation","<Date> was a public holiday in <Country>. Are you sure you want to enter hours for it");
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
        return (new WebDriverWait(webDriver, 60).until(ExpectedConditions.visibilityOfElementLocated(By.id(elementid))));
    }
    public void setUpAndroid() {
        FirefoxProfile firefoxProfile = new FirefoxProfile();
        String userAgent = "Android 4.0.4 - Opera 12.00";
        firefoxProfile.setPreference("general.useragent.override", userAgent);
        webDriver = new FirefoxDriver(firefoxProfile);
        webDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    protected String getExpectedErrorMessage(String messageId) {
        return expectedMessages.get(messageId);
    }


}
