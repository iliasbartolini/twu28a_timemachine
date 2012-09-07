package functional.com.thoughtworks.twu;


import com.thoughtworks.twu.domain.Country;
import com.thoughtworks.twu.domain.LocationPresences;
import com.thoughtworks.twu.service.CountryService;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;


public class NewTimesheetTest extends BaseTest {


    private String validPasswordString = "Th0ughtW0rks@12";
    private CountryService countryService;

    public NewTimesheetTest() throws UnknownHostException {
        super();
    }

    @Before
    public void setup() throws UnknownHostException {
        super.setUpAndroid();
        countryService = new CountryService();
        webDriver.get(dashboardUrl);
        super.submitCredentials(validPasswordString);
    }

    @Test
    @Ignore("Page name conflict to be resolved")
    public void checkIfCountryBlankInitially() throws UnknownHostException {
        webDriver.get(newTimesheetUrl);
        Select selectBox = new Select(webDriver.findElement(By.id("country")));
        assertThat(selectBox.getFirstSelectedOption().getText(), is("Select a country"));
    }

    @Test
    @Ignore("Page name conflict to be resolved")
    public void checkIfCountryCanBeSelected() throws UnknownHostException {
        webDriver.get(newTimesheetUrl);
        WebElement country = webDriver.findElement(By.id("country"));
        assertThat(country.isEnabled(), is(true));
    }


    @Test
    @Ignore("Page name conflict to be resolved")
    public void checkIfEntireCountryListIsAvailable() throws UnknownHostException {
        webDriver.get(newTimesheetUrl);
        List<String> obtainedCountryNames = getActualCountryList();

        List<String> expectedCountryNames = getExpectedCountryList(countryService);
        assertEquals(expectedCountryNames, obtainedCountryNames);
    }


    @Test
    @Ignore("Page name conflict to be resolved")
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
    @Ignore("Page name conflict to be resolved")
    public void checkIfStateIsDisabledOnPageLoad() throws UnknownHostException {
        //Assuage
        webDriver.get(newTimesheetUrl);
        //Act
        WebElement state = webDriver.findElement(By.id("state"));
        //Assert
        assertThat(state.isEnabled(), is(false));
    }

    @Test
    @Ignore("Page name conflict to be resolved")
    public void givenUSAIsSelectedStatesShouldBeEnabled() {
        //Assuage

        webDriver.get(newTimesheetUrl);

        //Act
        selectCountry("USA - USA");
        WebElement state = webDriver.findElement(By.id("state"));

        assertThat(state.isEnabled(), is(true));
    }

    @Test
    @Ignore("Page name conflict to be resolved")
    public void changeCountryUSAToOtherStatesEmpty() {
        //Assuage
        webDriver.get(newTimesheetUrl);
        selectCountry("USA - USA");
        selectState("GA");
        //Act
        selectCountry("IND - India");
        WebElement state = webDriver.findElement(By.id("state"));
        Select dropDownState = new Select(state);
        assertEquals("", dropDownState.getFirstSelectedOption().getText());
    }

    @Test
    @Ignore("Page name conflict to be resolved")
    public void checkIfStateListIsAvailable() throws Exception {
        //Assuage
        webDriver.get(newTimesheetUrl);
        selectCountry("USA - USA");
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
            expectedCountryNames.add(expectedCountry.getCode()+" - "+expectedCountry.getName());
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

