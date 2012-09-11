package com.thoughtworks.twu.controller;

import com.thoughtworks.twu.domain.Country;
import com.thoughtworks.twu.domain.LocationPresences;
import com.thoughtworks.twu.domain.timesheet.forms.TimeRecordForm;
import com.thoughtworks.twu.service.CountryService;
import com.thoughtworks.twu.service.MessageService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.validation.BindingResult;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.Assert.assertEquals;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class TimeRecordControllerTest {

    TimeRecordController controller;

    private CountryService countryService ;

    private TimeRecordForm timeRecordForm;
    private BindingResult bindingResult;

    private List<Country> countries = new ArrayList<Country>();
    private List<String> expectedNames = new ArrayList<String>();
    private List<String> expectedStatesName = new ArrayList<String>();
    private List<LocationPresences> locationPresenceList=  new ArrayList<LocationPresences>();
    private MessageService messageService;

    @Before
    public void setUp() throws Exception {

        timeRecordForm = new TimeRecordForm();
        bindingResult = mock(BindingResult.class);

        Country country = new Country();
        country.setName("USA");
        country.setCode("USA");

        countries.add(country);
        expectedNames.add("Select a country");
        expectedNames.add("USA - USA");



        LocationPresences locationPresences = new LocationPresences();
        locationPresences.setCountryCode("USA");
        locationPresences.setState("GA");
        locationPresences.setThoughtworksPresence(1);
        locationPresenceList.add(locationPresences);
        expectedStatesName.add("Select a state");
        expectedStatesName.add("GA");

        countryService = mock(CountryService.class);
        messageService = mock(MessageService.class);
        controller = new TimeRecordController(countryService, messageService);
    }

    @Test
    public void shouldBeAbleToGetViewNameOfController() throws Exception {
        assertEquals("ui/timesheet/time_record", controller.newTimesheet(timeRecordForm,bindingResult).getViewName());
    }

    @Test
    public void shouldReturnCountryNames() throws Exception
    {
       List<String> countryNames = controller.loadCountryNames(countries);
       assertThat(countryNames, is(expectedNames));

    }

    @Test
    public void shouldReturnStateNames() throws Exception
    {
        when(countryService.getStates("USA")).thenReturn(locationPresenceList);

        List<String> stateNames= controller.loadStateNames(locationPresenceList);

        assertEquals(expectedStatesName, stateNames);

    }

}
