package com.thoughtworks.twu.service;

import com.thoughtworks.twu.domain.Timesheet;
import org.junit.Test;

import java.sql.Date;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class TimesheetServiceTest {



    @Test
    public void shouldSaveTimesheetToDB() {
        TimesheetService service = new TimesheetService();

        Timesheet batmansTimesheet = new Timesheet();
        batmansTimesheet.setWeek_ending_date(new Date(System.currentTimeMillis()));

        service.saveTimesheet(batmansTimesheet);

        List<Timesheet> timesheetList = service.getAllTimesheets();

        assertTrue(timesheetList.contains(batmansTimesheet));

    }

    @Test
    public void shouldAddNewTimesheet() {
        TimesheetService service = new TimesheetService();

        Timesheet batmansTimesheet = service.addNewTimeSheet();

        List<Timesheet> timesheetList = service.getAllTimesheets();

        assertTrue(timesheetList.contains(batmansTimesheet));

    }

}
