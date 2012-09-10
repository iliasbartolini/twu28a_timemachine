package com.thoughtworks.twu.domain.timesheet.forms;

import com.thoughtworks.twu.domain.Timesheet;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class TimesheetForm {
    
    private String weekEndingDate;

    public void setWeekEndingDate(String weekEndingDate) {
        this.weekEndingDate = weekEndingDate;
    }

    public Timesheet toTimesheet()  {

        DateFormat date = new SimpleDateFormat("dd-MMM-yy");
        Timesheet timesheet = new Timesheet();
        try {
            timesheet.setWeekEndingDate(date.parse(weekEndingDate));
        } catch (ParseException e) {
            return null;
        }
        return timesheet;
    }

    public String getWeekEndingDate() {
        return weekEndingDate;
    }


}
