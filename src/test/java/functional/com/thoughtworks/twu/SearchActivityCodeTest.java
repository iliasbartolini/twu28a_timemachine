package functional.com.thoughtworks.twu;

import constants.TestData;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.hamcrest.CoreMatchers.is;

import static org.junit.matchers.JUnitMatchers.containsString;
import static org.junit.Assert.assertThat;
import static org.testng.AssertJUnit.*;


import java.net.UnknownHostException;
import java.util.List;


public class SearchActivityCodeTest extends BaseTest {

    public SearchActivityCodeTest() throws UnknownHostException {
        super();
    }

    @Before
    public void setup() throws UnknownHostException {
        super.setUpAndroid();
        webDriver.get(dashboardUrl);
        super.submitCredentials(TestData.validPasswordString);
        webDriver.findElement(By.id("new_timesheet")).click();
        webDriver.findElement(By.id("timeRecord")).click();
        webDriver.findElement(By.id("searchActivity")).click();
    }

    @Test
    @Ignore("Problem with text identification of Search Activity")
    public void shouldReturnActivityCodeToActivityCodeField() {
        enterSearchString("SZD_TRN");
        WebElement selectedActivityCode = webDriver.findElement(By.className("ui-li-heading"));
        selectedActivityCode.click();
        assertThat(webDriver.findElement(By.id("header")).getText(),is(selectedActivityCode.getText()));
    }

    @Test
    public void shouldShowErrorForSearchStringLessThan2Characters() {
        enterSearchString("a");
        assertEquals(getExpectedErrorMessage("Alteast2CharsForSearch"),waitForVisibilityOfElementById("result").getText());
    }

    @Test
    public void shouldShowErrorForNoMatchFound() {
        enterSearchString("XYZZ");
        assertTrue(new WebDriverWait(webDriver, 60).until(ExpectedConditions.textToBePresentInElement(By.id("result"), expectedMessages.get("NoMatchingActivity"))));
    }

    @Test
    public void checkForPlaceholderTextOnEmptySearchBar() {
        assertEquals("Search...Type in 2 or more characters",waitForVisibilityOfElementById("searchCriteria").getAttribute("placeholder").toString());
    }

    @Test
    public void shouldHandleUnderscoreProperly() {
        String searchString = "SER_E";
        enterSearchString(searchString);
        List<WebElement> searchResults = webDriver.findElements(By.className("ui-link-inherit"));
        for(WebElement element : searchResults) {
            assertThat(element.getText(),containsString(searchString));
        }
    }
    @Test
    @Ignore("BUG Not handled")
    public void shouldHandleModulusProperly() {
        String searchString = "RORZ%YTYOO96";
        enterSearchString(searchString);
        List<WebElement> searchResults = webDriver.findElements(By.className("ui-link-inherit"));
        for(WebElement element : searchResults) {
            assertThat(element.getText(),containsString("RORZ"));
            assertThat(element.getText(),containsString("YTYOO96"));
        }
    }
    @Test
    @Ignore("Not implemented")
    public void shouldSetBillableFlagAsNoForNonBillableActivity() {
        enterSearchString("YTYOO96");
        webDriver.findElement(By.id("activity0")).click();
        assertEquals("No",webDriver.findElement(By.className("ui-slider-label")).getText());
        assertTrue(!webDriver.findElement(By.className("ui-slider-label")).isEnabled());
    }

    @After
    public void teardown() {
        webDriver.close();
    }



}
