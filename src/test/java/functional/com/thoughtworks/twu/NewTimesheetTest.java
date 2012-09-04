package functional.com.thoughtworks.twu;


import com.thoughtworks.selenium.Selenium;
import com.thoughtworks.twu.domain.Country;
import com.thoughtworks.twu.domain.LocationPresences;
import com.thoughtworks.twu.service.CountryService;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.support.ui.Select;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class NewTimesheetTest extends BaseTest {


    private String validPasswordString = "Th0ughtW0rks@12";
    private String newTimesheetUrl;

    @Before
    public void setup() throws UnknownHostException {
        super.setUpAndroid();
        String url = InetAddress.getLocalHost().getHostName() + ":9093/timemachine";
        webDriver.get(url);
        super.submitCredentials(validPasswordString);
        newTimesheetUrl = InetAddress.getLocalHost().getHostName() + ":9093/timemachine/timesheet/new";

    }

    @Test
    public void checkIfCountryBlankInitially() throws UnknownHostException {
        //Assuage
        // Selenium browser = new WebDriverBackedSelenium(webDriver, url);
        webDriver.get(newTimesheetUrl);

        //Act
        Select selectBox = new Select(webDriver.findElement(By.id("country")));
        //Assert
        assertThat(selectBox.getFirstSelectedOption().getText(), is("Select a country"));

    }

    @Test
    public void checkIfCountryCanBeSelected() throws UnknownHostException {
        //Assuage
        webDriver.get(newTimesheetUrl);
        //Act
        WebElement country = webDriver.findElement(By.id("country"));
        //Assert
        assertThat(country.isEnabled(), is(true));
    }


    @Test
    public void checkIfEntireCountryListIsAvailable() throws UnknownHostException {
        //Assuage
        webDriver.get(newTimesheetUrl);

        //Act
        WebElement country = webDriver.findElement(By.id("country"));
        Select dropDown = new Select(country);
        List<WebElement> options = dropDown.getOptions();
        List<String> obtainedCountryNames = new ArrayList<String>();
        for (WebElement pageCountry : options) {
            obtainedCountryNames.add(pageCountry.getText());
        }

        CountryService countryService = new CountryService();
        List<Country> expectedCountries = countryService.getCountries();
        List<String> expectedCountryNames = new ArrayList<String>();
        expectedCountryNames.add("Select a country");
        for (Country expectedCountry : expectedCountries) {
            expectedCountryNames.add(expectedCountry.getName());
        }
        //Assert
        assertEquals(expectedCountryNames, obtainedCountryNames);
    }



    @Test
    public void checkIfStateIsBlankInitially() throws UnknownHostException {
        //Assuage
        webDriver.get(newTimesheetUrl);
        //Act
        WebElement state = webDriver.findElement(By.id("state"));
        Select dropDownState = new Select(state);

        //Assert
        assertEquals("", dropDownState.getFirstSelectedOption().getText());
    }


    @Test
    public void checkIfStateIsDisabledOnPageLoad() throws UnknownHostException {
        //Assuage
        webDriver.get(newTimesheetUrl);
        //Act
        WebElement state = webDriver.findElement(By.id("state"));
        //Assert
        assertThat(state.isEnabled(), is(false));
    }

    @Test
    public void givenUSAIsSelectedStatesShouldBeEnabled() {
        //Assuage

        webDriver.get(newTimesheetUrl);


        //Act
        WebElement country = webDriver.findElement(By.id("country"));
        Select dropDownCountry = new Select(country);
        dropDownCountry.selectByValue("USA");


        WebElement state = webDriver.findElement(By.id("state"));
        Select dropDownState = new Select(state);
        List<WebElement> states = dropDownState.getOptions();


        List<String> obtainedStateNames = new ArrayList<String>();
        for (WebElement pageState : states) {
            obtainedStateNames.add(pageState.getText());
        }

        CountryService countryService = new CountryService();
        List<LocationPresences> expectedStates = countryService.getStates("USA");
        List<String> expectedStateNames = new ArrayList<String>();
        expectedStateNames.add("Select a state");
        for (LocationPresences expectedState : expectedStates) {
            expectedStateNames.add(expectedState.getState());
        }
        //Assert
        assertEquals(expectedStateNames, obtainedStateNames);

    }

    @Test
    public void changeCountryUSAToOtherStatesEmpty() {
        //Assuage
        webDriver.get(newTimesheetUrl);

        //Act
        WebElement country = webDriver.findElement(By.id("country"));
        Select dropDownCountry = new Select(country);
        dropDownCountry.selectByValue("USA");

        WebElement state = webDriver.findElement(By.id("state"));
        Select dropDownState = new Select(state);
        List<WebElement> states = dropDownState.getOptions();
        assertEquals("Select a state", dropDownState.getFirstSelectedOption().getText());
    }



    @After
    public void tearDown() {
        webDriver.close();
    }


}

