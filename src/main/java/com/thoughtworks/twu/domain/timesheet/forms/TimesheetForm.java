package com.thoughtworks.twu.domain.timesheet.forms;

import com.thoughtworks.twu.domain.Employee;
import com.thoughtworks.twu.domain.Timesheet;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class TimesheetForm {
    
    private String weekEndingDate="";
    private String id;

    public void setWeekEndingDate(String weekEndingDate) {
        this.weekEndingDate = weekEndingDate;
    }

    public Timesheet toTimesheet(Employee employee)  {

        DateFormat date = new SimpleDateFormat("dd-MMM-yy");
        Timesheet timesheet = new Timesheet();
        try {
            timesheet.setWeekEndingDate(date.parse(weekEndingDate));
        } catch (ParseException e) {
            return null;
        }

        timesheet.setEmployeeNumber(String.valueOf(employee.getEmployeeNumber()));
        return timesheet;
    }

    public String getWeekEndingDate() {
        return weekEndingDate;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TimesheetForm that = (TimesheetForm) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (weekEndingDate != null ? !weekEndingDate.equals(that.weekEndingDate) : that.weekEndingDate != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = weekEndingDate != null ? weekEndingDate.hashCode() : 0;
        result = 31 * result + (id != null ? id.hashCode() : 0);
        return result;
    }

    public String getId() {
        return id;
    }
}
