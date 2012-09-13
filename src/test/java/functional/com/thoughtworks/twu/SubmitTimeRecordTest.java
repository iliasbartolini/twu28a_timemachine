package functional.com.thoughtworks.twu;

import constants.TestData;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import static org.junit.Assert.assertThat;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;


import java.util.List;

public class SubmitTimeRecordTest extends  BaseTest{

    public SubmitTimeRecordTest() throws Exception{
        super();
    }

    @Before
    public void setup() {
        super.setUpAndroid();
        webDriver.get(dashboardUrl);
        super.submitCredentials(TestData.validPasswordString);
        webDriver.findElement(By.id("new_timesheet")).click();
        webDriver.findElement(By.id("timeRecord")).click();
    }
    @Test
    public void shouldShowMessageWhenActivityNotChosen() {
        List<String> stringErrorMessages = getAllErrorMessagesDisplayed();
        assertTrue(stringErrorMessages.contains(getExpectedErrorMessage("ActivityCannotBeUnspecified")));
    }
    @Test
    public void shouldShowMessageWhenTaskCommentBlank() {
        List<String> stringErrorMessages = getAllErrorMessagesDisplayed();
        assertTrue(stringErrorMessages.contains(getExpectedErrorMessage("TaskCommentCannotBeUnspecified")));
    }
    //@After
    public void teardown() {
        webDriver.close();
    }

}
