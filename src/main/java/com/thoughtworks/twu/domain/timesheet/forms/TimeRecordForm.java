package com.thoughtworks.twu.domain.timesheet.forms;

import java.util.Date;

public class TimeRecordForm {

    private String country;
    private String state;
    private String activity;
    private boolean billable = true;
    private String taskComment;
    private Float monday;
    private Float tuesday;
    private Float wednesday;
    private Float thursday;
    private Float friday;
    private Float saturday;
    private Float sunday;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    private Date date;


    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getActivity() {
        return activity;
    }

    public void setActivity(String activity) {
        this.activity = activity;
    }

    public boolean isBillable() {
        return billable;
    }

    public void setBillable(boolean billable) {
        this.billable = billable;
    }

    public String getTaskComment() {
        return taskComment;
    }

    public void setTaskComment(String taskComment) {
        this.taskComment = taskComment;
    }

    public Float getMonday() {
        return convertToFloat(monday);
    }

    public void setMonday(Float monday) {
        this.monday = monday;
    }

    public Float getTuesday() {
        return convertToFloat(tuesday);
    }

    public void setTuesday(Float tuesday) {
        this.tuesday = tuesday;
    }

    public Float getWednesday() {
        return convertToFloat(wednesday);
    }

    public void setWednesday(Float wednesday) {
        this.wednesday = wednesday;
    }

    public Float getThursday() {
        return convertToFloat(thursday);
    }

    public void setThursday(Float thursday) {
        this.thursday = thursday;
    }

    public Float getFriday() {
        return convertToFloat(friday);
    }

    public void setFriday(Float friday) {
        this.friday = friday;
    }

    public Float getSaturday() {
        return convertToFloat(saturday);
    }

    public void setSaturday(Float saturday) {
        this.saturday = saturday;
    }

    public Float getSunday() {
        return convertToFloat(sunday);
    }

    public void setSunday(Float sunday) {
        this.sunday = sunday;
    }

    public float convertToFloat(Float value)
    {
        if(value==null)
            return 0f;
        else
            return value;
    }
}
