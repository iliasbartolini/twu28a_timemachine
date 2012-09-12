package com.thoughtworks.twu.controller;

import com.thoughtworks.twu.domain.Country;
import com.thoughtworks.twu.domain.LocationPresences;
import com.thoughtworks.twu.domain.TimeRecord;
import com.thoughtworks.twu.domain.timesheet.forms.TimeRecordForm;
import com.thoughtworks.twu.service.CountryService;
import com.thoughtworks.twu.service.MessageService;
import com.thoughtworks.twu.service.TimeRecordService;
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

    private CountryService countryService;
    private TimeRecordService timeRecordService;

    private TimeRecordForm timeRecordForm;
    private BindingResult bindingResult;

    private List<Country> countries = new ArrayList<Country>();
    private List<String> expectedNames = new ArrayList<String>();
    private List<String> expectedStatesName = new ArrayList<String>();

    private MessageService messageService;
    private List<LocationPresences> locationPresenceList = new ArrayList<LocationPresences>();
    private TimeRecord newTimeRecords;
    private int timesheetID;

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

        timeRecordForm = new TimeRecordForm();
        timeRecordForm.setActivity("TWU");
        timeRecordForm.setCountry("USA");

        timesheetID = 0;

        newTimeRecords = new TimeRecord();
        newTimeRecords.setTime_sheet_id(timesheetID);
        newTimeRecords.setId(0);
        newTimeRecords.setProject("TWU");
        newTimeRecords.setCountry("USA");

        countryService = mock(CountryService.class);
        messageService = mock(MessageService.class);
        controller = new TimeRecordController(countryService, timeRecordService, messageService);
        timeRecordService = mock(TimeRecordService.class);

        controller = new TimeRecordController(countryService, timeRecordService, messageService);
    }

    @Test
    public void shouldBeAbleToGetViewNameOfController() throws Exception {
        assertEquals("ui/timesheet/time_record", controller.newTimeRecord().getViewName());
    }

    @Test
    public void shouldReturnCountryNames() throws Exception {
        List<String> countryNames = controller.loadCountryNames(countries);
        assertThat(countryNames, is(expectedNames));

    }

    @Test
    public void shouldReturnStateNames() throws Exception {
        when(countryService.getStates("USA")).thenReturn(locationPresenceList);

        List<String> stateNames = controller.loadStateNames(locationPresenceList);

        assertEquals(expectedStatesName, stateNames);

    }


    @Test
    public void shouldBeAbleToSaveTimeRecord() throws Exception {

        TimeRecordServiceStub timeRecordService = new TimeRecordServiceStub();

        controller = new TimeRecordController(null, timeRecordService,null);
        controller.save(timeRecordForm, timesheetID);

        TimeRecord actualTimeRecord = timeRecordService.getTimeRecord();
        assertThat(actualTimeRecord.getProject(), is(timeRecordForm.getActivity()));

    }

    private class TimeRecordServiceStub extends TimeRecordService {
        private TimeRecord timeRecord;

        @Override
        public void save(TimeRecord newTimeRecords) {
            this.timeRecord = newTimeRecords;
        }

        public TimeRecord getTimeRecord() {
            return timeRecord;
        }
    }
}
