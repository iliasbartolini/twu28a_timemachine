package functional.com.thoughtworks.twu;


import com.thoughtworks.twu.domain.LocationPresences;
import com.thoughtworks.twu.service.CountryService;
import org.junit.After;
import org.junit.Before;
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
import static org.junit.Assert.assertTrue;
import static org.junit.internal.matchers.IsCollectionContaining.hasItems;


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
        webDriver.get(timeRecordUrl);
    }

    @Test
    public void shouldShowSelectCountryMessageOnPageLoad() throws UnknownHostException {
        Select selectBox = new Select(webDriver.findElement(By.id("country")));
        assertThat(selectBox.getFirstSelectedOption().getText(), is("Select a country"));
    }

    @Test
    //@Ignore("Page name conflict to be resolved")
    public void checkIfCountryCanBeSelected() throws UnknownHostException {
        WebElement country = webDriver.findElement(By.id("country"));
        assertThat(country.isEnabled(), is(true));
    }


    @Test
    public void shouldDisplayCountryListWithBothCountryCodeAndName() throws UnknownHostException {
        List<String> obtainedCountryNames = getActualCountryList();
        List<String> expectedCountryNames = getExpectedCountryList();
        assertTrue(obtainedCountryNames.containsAll(expectedCountryNames));
    }

    @Test
    //@Ignore("Page name conflict to be resolved")
    public void checkIfStateIsBlankInitially() throws UnknownHostException {
        //Assuage
        //Act
        WebElement state = webDriver.findElement(By.id("state"));
        Select dropDownState = new Select(state);

        //Assert
        assertEquals("", dropDownState.getFirstSelectedOption().getText());
    }


    @Test
    //@Ignore("Page name conflict to be resolved")
    public void checkIfStateIsDisabledOnPageLoad() throws UnknownHostException {
        //Assuage

        //Act
        WebElement state = webDriver.findElement(By.id("state"));
        //Assert
        assertThat(state.isEnabled(), is(false));
    }

    @Test
    //@Ignore("Page name conflict to be resolved")
    public void givenUSAIsSelectedStatesShouldBeEnabled() {
        //Assuage


        //Act
        selectCountry("USA - USA");
        WebElement state = webDriver.findElement(By.id("state"));

        assertThat(state.isEnabled(), is(true));
    }

    @Test
    //@Ignore("Page name conflict to be resolved")
    public void changeCountryUSAToOtherStatesEmpty() {
        //Assuage
        selectCountry("USA - USA");
        selectState("GA");
        //Act
        selectCountry("IND - India");
        WebElement state = webDriver.findElement(By.id("state"));
        Select dropDownState = new Select(state);
        assertEquals("", dropDownState.getFirstSelectedOption().getText());
    }

    @Test
    //@Ignore("Page name conflict to be resolved")
    public void checkIfStateListIsAvailable() throws Exception {
        //Assuage
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


    private List<String> getExpectedCountryList() {
        List<String> expectedCountryNames = new ArrayList<String>();
        expectedCountryNames.add("Select a country");
        expectedCountryNames.add("USA - USA");
        expectedCountryNames.add("IND - India");
        return expectedCountryNames;
    }

    private ArrayList<String> getActualCountryList() {
        WebElement country = webDriver.findElement(By.id("country"));
        Select dropDown = new Select(country);
        List<WebElement> options = dropDown.getOptions();
        ArrayList<String> obtainedCountryNames = new ArrayList<String>();
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

