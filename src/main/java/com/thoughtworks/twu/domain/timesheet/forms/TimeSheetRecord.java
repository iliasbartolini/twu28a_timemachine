package com.thoughtworks.twu.domain.timesheet.forms;

import java.util.Date;

public class TimeSheetRecord {

    private String country;
    private String state;
    private String activity;
    private boolean billable = true;
    private String taskComment;
    private float monday;
    private float tuesday;
    private float wednesday;
    private float thursday;
    private float friday;
    private float saturday;
    private float sunday;

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

    public float getMonday() {
        return monday;
    }

    public void setMonday(float monday) {
        this.monday = monday;
    }

    public float getTuesday() {
        return tuesday;
    }

    public void setTuesday(float tuesday) {
        this.tuesday = tuesday;
    }

    public float getWednesday() {
        return wednesday;
    }

    public void setWednesday(float wednesday) {
        this.wednesday = wednesday;
    }

    public float getThursday() {
        return thursday;
    }

    public void setThursday(float thursday) {
        this.thursday = thursday;
    }

    public float getFriday() {
        return friday;
    }

    public void setFriday(float friday) {
        this.friday = friday;
    }

    public float getSaturday() {
        return saturday;
    }

    public void setSaturday(float saturday) {
        this.saturday = saturday;
    }

    public float getSunday() {
        return sunday;
    }

    public void setSunday(float sunday) {
        this.sunday = sunday;
    }


}
