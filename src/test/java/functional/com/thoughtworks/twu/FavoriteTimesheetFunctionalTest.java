package functional.com.thoughtworks.twu;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class FavoriteTimesheetFunctionalTest {

    private WebDriver webDriver;

    @Before
    public void setUp() {
        webDriver = new FirefoxDriver();
    }

    @Test
    public void should() {
        webDriver.get("http://localhost:8080/twu/timesheet/favorite/new");
        WebElement h1 = webDriver.findElement(By.tagName("h1"));

        assertThat(h1.getText(), is("Create New Favorite Timesheet"));
    }

    @After
    public void tearDown() {
        webDriver.close();
    }
}
