package com.thoughtworks.twu.domain;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: ewonou
 * Date: 4/9/12
 * Time: 10:38 AM
 * To change this template use File | Settings | File Templates.
 */
public class NewTimesheetForm {

    private String country;
    private String state;
    private String activity;


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

}
