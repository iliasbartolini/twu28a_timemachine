package com.thoughtworks.twu.domain.forms;

import com.thoughtworks.twu.domain.timesheet.TimeSheetEntry;

import java.util.List;

public class FavoriteTimeSheetForm {
    private String name = "";
    //public List<TimeSheetEntry> timeEntries;
    private TimeSheetEntry timeEntry;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public TimeSheetEntry getTimeEntry() {
        return timeEntry;
    }

    public void setTimeEntry(TimeSheetEntry timeEntry) {
        this.timeEntry = timeEntry;
    }
}
