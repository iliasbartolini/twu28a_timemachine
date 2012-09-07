package functional.com.thoughtworks.twu;

import com.thoughtworks.twu.domain.Message;
import com.thoughtworks.twu.service.CountryService;
import com.thoughtworks.twu.service.MessageService;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.hamcrest.CoreMatchers.is;

import static org.junit.Assert.assertThat;
import static org.testng.AssertJUnit.assertNotNull;

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
        //Assuage
        //Act
        String selectedActivityCode = searchAndSelectActivity("YTYOO96");
        //Assert
        assertThat(webDriver.findElement(By.id("activity")).getText(),is(selectedActivityCode));
    }
    @Test
    public void shouldShowErrorForSearchStringLessThan2Characters() {
        //Assuage
        //Act
        enterSearchString("a");
        //Assert
        assertThat(getObtainedErrorMessage(),is(getExpectedErrorMessage("Alteast2CharsForSearch")));
    }
    @Test
    //@Ignore("Search Activity Not Ready")
    public void shouldShowErrorForNoMatchFound() {
        //Assuage
        //Act
        enterSearchString("XYZZZZZZZZ");
        //Assert
        assertNotNull(webDriver.findElement(By.id("result")));
        assertThat(webDriver.findElement(By.id("result")).getText(),is(getExpectedErrorMessage("NoMatchingActivity")));
    }
    @Test
    @Ignore("Search Activity Not Ready")
    public void shouldSetBillableFlagAsNoForNonBillableActivity() {
        //Assuage
        //Act
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
        WebDriverWait wait = new WebDriverWait(webDriver, 10);
        WebElement search = wait.until(ExpectedConditions.visibilityOf(webDriver.findElement(By.id("searchCriteria"))));
        search = webDriver.findElement(By.id("searchCriteria"));
        search.clear();
        search.sendKeys(searchString);
        search.submit();
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
    private String getObtainedErrorMessage() {
        WebElement messageElement = webDriver.findElement(By.id("result"));
        return messageElement.getText();
    }
}
