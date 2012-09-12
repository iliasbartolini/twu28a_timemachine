package com.thoughtworks.twu.domain;

import javax.persistence.*;


@Entity
@Table(name = "TIME_RECORDS")
public class TimeRecord {

    @Id
//    @GeneratedValue(generator = "id")
//    @GenericGenerator(name = "id", strategy = "increment")
    private int id;

    private int time_sheet_id;
    private String project;
    private String sub_project;
    private int billable;
    private String task_comment;
    private String client;
    private String country;
    private String state;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTime_sheet_id() {
        return time_sheet_id;
    }

    public void setTime_sheet_id(int time_sheet_id) {
        this.time_sheet_id = time_sheet_id;
    }

    public String getProject() {
        return project;
    }

    public void setProject(String project) {
        this.project = project;
    }

    public String getSub_project() {
        return sub_project;
    }

    public void setSub_project(String sub_project) {
        this.sub_project = sub_project;
    }

    public int getBillable() {
        return billable;
    }

    public void setBillable(int billable) {
        this.billable = billable;
    }

    public String getTask_comment() {
        return task_comment;
    }

    public void setTask_comment(String task_comment) {
        this.task_comment = task_comment;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

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
}