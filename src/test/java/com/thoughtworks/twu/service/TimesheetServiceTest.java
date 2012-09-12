package com.thoughtworks.twu.service;

import com.thoughtworks.twu.domain.Timesheet;
import org.junit.Before;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import static org.apache.commons.lang.CharRange.isNot;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class TimesheetServiceTest {

    private TimesheetService timesheetService;
    private Timesheet batmansTimesheet;
    private int timesheetID;

    @Before
    public void setUp() throws Exception {
        timesheetID = 1;
        timesheetService = new TimesheetService();
        batmansTimesheet = new Timesheet();
        batmansTimesheet.setWeekEndingDate(new SimpleDateFormat("dd-MMM-yy").parse("15-Sep-12"));
        batmansTimesheet.setEmployeeNumber("1122");


    }

    @Test
    public void shouldSaveTimesheetToDB() throws ParseException {
        long timesheetID = timesheetService.saveTimesheet(batmansTimesheet);

        assertTrue(timesheetID != 0);
    }

    @Test
    public void shouldGetAllTimesheet() {

        List<Timesheet> timesheetList = timesheetService.getAllTimesheets();

        assertThat(timesheetList.size(), is(1));

    }

    @Test
    public void shouldBeAbleToReturnTimesheetById() throws Exception {
        timesheetService.saveTimesheet(batmansTimesheet);

        Timesheet actualTimesheet = timesheetService.getTimeSheetById(batmansTimesheet.getId());

        assertThat(actualTimesheet, is(batmansTimesheet));
    }
}
