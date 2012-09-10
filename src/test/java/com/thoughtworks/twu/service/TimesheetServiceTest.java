package com.thoughtworks.twu.service;

import com.thoughtworks.twu.domain.Timesheet;
import org.junit.Test;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class TimesheetServiceTest {



    @Test
    public void shouldSaveTimesheetToDB() throws ParseException {
        TimesheetService service = new TimesheetService();

        Timesheet batmansTimesheet = new Timesheet();
        batmansTimesheet.setWeekEndingDate(new SimpleDateFormat("dd-MMM-yy").parse("15-Sep-12"));

        service.saveTimesheet(batmansTimesheet);

        List<Timesheet> timesheetList = service.getAllTimesheets();

        assertTrue(timesheetList.contains(batmansTimesheet));
    }

    @Test
    public void shouldAddNewTimesheet() {
        TimesheetService service = new TimesheetService();

        Timesheet batmansTimesheet = service.createNewTimesheet();

        List<Timesheet> timesheetList = service.getAllTimesheets();

        assertTrue(timesheetList.contains(batmansTimesheet));

    }

}
