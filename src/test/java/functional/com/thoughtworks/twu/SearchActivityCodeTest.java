package functional.com.thoughtworks.twu;

import com.thoughtworks.twu.domain.Message;
import com.thoughtworks.twu.service.CountryService;
import com.thoughtworks.twu.service.MessageService;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.hamcrest.CoreMatchers.is;

import static org.junit.Assert.assertThat;
import static org.testng.AssertJUnit.assertEquals;


import java.net.InetAddress;
import java.net.UnknownHostException;


public class SearchActivityCodeTest extends BaseTest {
    private String validPasswordString = "Th0ughtW0rks@12";
    private String timeRecordUrl;
    private CountryService countryService;
    @Before
    public void setup() throws UnknownHostException {
        super.setUpAndroid();
        timeRecordUrl = InetAddress.getLocalHost().getHostName() + ":9093/timemachine/timesheet/timeSheet";
        webDriver.get(timeRecordUrl);
        super.submitCredentials(validPasswordString);
        webDriver.findElement(By.id("timeRecord")).click();
        webDriver.findElement(By.id("searchActivityCode")).click();
    }

    @Test
    @Ignore("Search Activity Not Ready")
    public void shouldReturnActivityCodeToActivityCodeField() {
        String selectedActivityCode = searchAndSelectActivity("YTYOO96");
        assertThat(webDriver.findElement(By.id("activity")).getText(),is(selectedActivityCode));
    }

    @Test
    public void shouldShowErrorForSearchStringLessThan2Characters() {
        enterSearchString("a");
        assertEquals(getExpectedErrorMessage("Alteast2CharsForSearch"),waitForVisibilityOfElementById("result").getText());
    }

    @Test
    @Ignore("Inconsistency in response to be resolved")
    public void shouldShowErrorForNoMatchFound() {
        enterSearchString("XYZZ");
        assertEquals(getExpectedErrorMessage("NoMatchingActivity"),waitForVisibilityOfElementById("result").getText());
    }

    @Test
    @Ignore("Search Activity Not Ready")
    public void shouldSetBillableFlagAsNoForNonBillableActivity() {
        enterSearchString("YTYOO96");
        //Find element of list: There will be only one element
        //Element.click()
        //assertThat(webDriver.findElement(By.id("activity")).getText(),is("No"));
        //assertTrue(!webDriver.findElement(By.id("activity")).isEnabled())
    }

    @After
    public void teardown() {
        webDriver.close();
    }
    private void enterSearchString(String searchString){
        WebElement search = waitForVisibilityOfElementById("searchCriteria");
        search.sendKeys(searchString);
        search.submit();
    }

    private WebElement waitForVisibilityOfElementById(String elementid) throws TimeoutException {
        return (new WebDriverWait(webDriver, 10).until(ExpectedConditions.visibilityOfElementLocated(By.id(elementid))));
    }

    private String searchAndSelectActivity(String searchString) {
        webDriver.get(timeRecordUrl);
        enterSearchString(searchString);
        WebElement searchResult = webDriver.findElement(By.className("ui-li-heading"));
        String selectedActivityCode = searchResult.getText();
        searchResult.click();
        return selectedActivityCode;
    }
    private String getExpectedErrorMessage(String messageId) {
        MessageService messageService = new MessageService();
        Message message = messageService.getMessageMessageById(messageId);
        return message.getMessage();
    }
}
