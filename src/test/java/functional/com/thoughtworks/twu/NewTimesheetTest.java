package functional.com.thoughtworks.twu;


import com.thoughtworks.twu.domain.Country;
import com.thoughtworks.twu.domain.LocationPresences;
import com.thoughtworks.twu.service.CountryService;
import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class NewTimesheetTest extends BaseTest {


    private String validPasswordString = "Th0ughtW0rks@12";
    private String newTimesheetUrl;
    private CountryService countryService;

    @Before
    public void setup() throws UnknownHostException {
        countryService = new CountryService();

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
        assertThat(selectBox.getFirstSelectedOption().getText(), is(""));

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
        List<String> obtainedCountryNames = this.getActualCountry();

        List<String> expectedCountryNames = getExpectedCountry();
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


        List<String> obtainedStateNames = getActualStates();

        List<String> expectedStateNames = getExpectedStates();
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
        assertEquals("", dropDownState.getFirstSelectedOption().getText());
    }

    private List<String> getActualCountry() {

        WebElement country = webDriver.findElement(By.id("country"));
        Select dropDown = new Select(country);
        List<WebElement> options = dropDown.getOptions();
        List<String> obtainedCountryNames = new ArrayList<String>();
        for (WebElement pageCountry : options) {
            obtainedCountryNames.add(pageCountry.getText());
        }

        return obtainedCountryNames;
    }


    private List<String> getExpectedCountry() {
        List<Country> expectedCountries = countryService.getCountries();
        List<String> expectedCountryNames = new ArrayList<String>();
        expectedCountryNames.add("");
        for (Country expectedCountry : expectedCountries) {
            expectedCountryNames.add(expectedCountry.getName());
        }
        return expectedCountryNames;
    }


    private List<String> getExpectedStates() {
        List<LocationPresences> expectedStates = countryService.getStates("USA");
        List<String> expectedStateNames = new ArrayList<String>();
        expectedStateNames.add("");
        for (LocationPresences expectedState : expectedStates) {
            expectedStateNames.add(expectedState.getState());
        }
        return expectedStateNames;
    }

    private List<String> getActualStates() {
        WebElement state = webDriver.findElement(By.id("state"));
        Select dropDownState = new Select(state);
        List<WebElement> states = dropDownState.getOptions();


        List<String> obtainedStateNames = new ArrayList<String>();
        for (WebElement pageState : states) {
            obtainedStateNames.add(pageState.getText());
        }
        return obtainedStateNames;
    }

    @After
    public void tearDown() {
        webDriver.close();
    }


}

