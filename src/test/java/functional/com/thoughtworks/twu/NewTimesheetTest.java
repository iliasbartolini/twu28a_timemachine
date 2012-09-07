package functional.com.thoughtworks.twu;


import com.thoughtworks.twu.domain.Country;
import com.thoughtworks.twu.domain.LocationPresences;
import com.thoughtworks.twu.service.CountryService;

import org.junit.*;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;

import java.net.InetAddress;
import java.net.UnknownHostException;

import java.util.ArrayList;
import java.util.List;


public class NewTimesheetTest extends BaseTest {


    private String validPasswordString = "Th0ughtW0rks@12";
    private String newTimesheetUrl;
    private CountryService countryService;


    @Before
    public void setup() throws UnknownHostException {
        super.setUpAndroid();
        countryService = new CountryService();
        String url = InetAddress.getLocalHost().getHostName() + ":9093/timemachine";
        webDriver.get(url);
        super.submitCredentials(validPasswordString);
        newTimesheetUrl = InetAddress.getLocalHost().getHostName() + ":9093/timemachine/timesheet/timeRecord";
    }

    @Test
    public void checkIfCountryBlankInitially() throws UnknownHostException {
        //Assuage
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
        List<String> obtainedCountryNames = getActualCountryList();

        List<String> expectedCountryNames = getExpectedCountryList(countryService);
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
        selectCountry("USA");
        WebElement state = webDriver.findElement(By.id("state"));

        assertThat(state.isEnabled(), is(true));
    }

    @Test
    public void changeCountryUSAToOtherStatesEmpty() {
        //Assuage
        webDriver.get(newTimesheetUrl);
        selectCountry("USA");
        selectState("GA");
        //Act
        selectCountry("UEA");
        WebElement state = webDriver.findElement(By.id("state"));
        Select dropDownState = new Select(state);
        assertEquals("", dropDownState.getFirstSelectedOption().getText());
    }

    @Test
    public void checkIfStateListIsAvailable() throws Exception {
        //Assuage
        webDriver.get(newTimesheetUrl);
        selectCountry("USA");
        //Act
        List<String> obtainedStateNames = getActualStateList();

        List<String> expectedStateNames = getExpectedStateList();
        //Assert
        assertEquals(expectedStateNames, obtainedStateNames);

    }


    private void selectCountry(String countryName) {
        WebElement country = webDriver.findElement(By.id("country"));
        Select dropDownCountry = new Select(country);
        dropDownCountry.selectByValue(countryName);
    }


    private List<String> getExpectedCountryList(CountryService countryService) {
        List<Country> expectedCountries = countryService.getCountries();
        List<String> expectedCountryNames = new ArrayList<String>();
        expectedCountryNames.add("Select a country");
        for (Country expectedCountry : expectedCountries) {
            expectedCountryNames.add(expectedCountry.getName());
        }
        return expectedCountryNames;
    }

    private List<String> getActualCountryList() {
        WebElement country = webDriver.findElement(By.id("country"));
        Select dropDown = new Select(country);
        List<WebElement> options = dropDown.getOptions();
        List<String> obtainedCountryNames = new ArrayList<String>();
        for (WebElement pageCountry : options) {
            obtainedCountryNames.add(pageCountry.getText());
        }
        return obtainedCountryNames;
    }

    private List<String> getExpectedStateList() {
        List<LocationPresences> expectedStates = countryService.getStates("USA");
        List<String> expectedStateNames = new ArrayList<String>();
        expectedStateNames.add("Select a state");
        for (LocationPresences expectedState : expectedStates) {
            expectedStateNames.add(expectedState.getState());
        }
        return expectedStateNames;
    }

    private List<String> getActualStateList() {
        WebElement state = webDriver.findElement(By.id("state"));
        Select dropDownState = new Select(state);
        List<WebElement> states = dropDownState.getOptions();


        List<String> obtainedStateNames = new ArrayList<String>();
        for (WebElement pageState : states) {
            obtainedStateNames.add(pageState.getText());
        }
        return obtainedStateNames;
    }


    private void selectState(String stateName) {
        WebElement state = webDriver.findElement(By.id("state"));
        Select dropDownState = new Select(state);
        dropDownState.selectByValue(stateName);
    }

    @After
    public void tearDown() {
        webDriver.close();
    }


}

