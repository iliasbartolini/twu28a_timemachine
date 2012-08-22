package com.thoughtworks.twu.domain.timesheet;

import java.util.ArrayList;
import java.util.List;

public class TimeSheetEntry {

    private String country = "";
    private String state = "";
    private String activity = "";
    private boolean billable = false;
    private String taskComment = "";
    private List<Float> days = new ArrayList<Float>();

    @Override
    public String toString() {
        return "TimeSheetEntry{" +
                "country='" + country + '\'' +
                ", state='" + state + '\'' +
                ", activity='" + activity + '\'' +
                ", billable=" + billable +
                ", taskComment='" + taskComment + '\'' +
                '}';
    }
}
