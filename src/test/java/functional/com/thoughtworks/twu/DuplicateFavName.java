package functional.com.thoughtworks.twu;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;

import java.net.InetAddress;
import java.net.UnknownHostException;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created with IntelliJ IDEA.
 * User: twer
 * Date: 8/24/12
 * Time: 4:23 PM
 * To change this template use File | Settings | File Templates.
 */
public class DuplicateFavName {
    private WebDriver webDriver;

    @Before
    public void setUp() {
        FirefoxProfile firefoxProfile = new FirefoxProfile();
        String userAgent;
        userAgent = "iOS 5_1_1 - iPhone - Chrome (crios) 19.0.1084.60";
        userAgent = "Android 4.0.4 - Opera 12.00";
        firefoxProfile.setPreference("general.useragent.override", userAgent );
        webDriver = new FirefoxDriver(firefoxProfile);
    }

    @Test
    public void shouldShowErrorWhenDuplicate() throws UnknownHostException {

        InetAddress inetAddress = InetAddress.getLocalHost();
        String ipAddress = inetAddress.getHostAddress();
        String url = "http://" + ipAddress + ":8080/twu/timesheet/favorite/new";

        webDriver.get(url);
        WebElement name = webDriver.findElement(By.id("name"));

        assertThat(name.getText(), is(""));
        name.sendKeys("TWU");

        //SELECT NAME FROM DB WHERE NAME = name.gettext();
        //assertNotNull(return of query); x
        WebElement submit = webDriver.findElement(By.id("submit"));
        submit.submit();


        WebElement message = webDriver.findElement(By.xpath("//label[@class='error']"));
        assertThat(message.getText(),is("Duplicate name. Please try another name."));
    }

    @After
    public void tearDown() {
        webDriver.close();
    }

}
