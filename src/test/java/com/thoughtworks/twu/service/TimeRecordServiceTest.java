package com.thoughtworks.twu.service;

import com.thoughtworks.twu.domain.TimeRecords;
import com.thoughtworks.twu.domain.Time_Sheets;
import com.thoughtworks.twu.domain.Timesheet;
import org.junit.Ignore;
import org.junit.Test;

import java.sql.Date;
import java.util.List;

import static org.testng.AssertJUnit.assertTrue;

/**
 * Created with IntelliJ IDEA.
 * User: ewonou
 * Date: 4/9/12
 * Time: 10:11 PM
 * To change this template use File | Settings | File Templates.
 */
public class TimeRecordServiceTest {

    @Test
    @Ignore ("Ewonou/Ramya Not yet complete")
    public void shouldSaveTimeRecord(){

        TimeRecordService timeRecordService = new TimeRecordService();
        TimeRecords timeRecords = new TimeRecords() ;
        timeRecords.setCountry("India");

        TimesheetService timesheetService = new TimesheetService();
        Time_Sheets timesheet = new Time_Sheets();
        timesheet.setStatus("open");
        timesheet.setEmployee_number("1111");
        timesheet.setWeek_ending_date((new Date(System.currentTimeMillis())));

        timeRecordService.saveTimeRecord(timesheet);
    }
}
