package com.thoughtworks.twu.domain;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: ewonou
 * Date: 4/9/12
 * Time: 3:38 PM
 * To change this template use File | Settings | File Templates.
 */

    @Entity
    @Table(name = "time_sheets")

    public class Time_Sheets {

    @Id
    @GeneratedValue(generator = "id")
    @GenericGenerator(name = "id", strategy = "increment")

    private int id;
    private String employee_number;
    private Date week_ending_date;
    private String created_by;
    private Date created_at;
    private String updated_by;
    private Date updated_at;
    private String status;
    private int expenses;
    private String submitted_by;
    private int lock_version;
    private Date submitted_at;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmployee_number() {
        return employee_number;
    }

    public void setEmployee_number(String employee_number) {
        this.employee_number = employee_number;
    }

    public Date getWeek_ending_date() {
        return week_ending_date;
    }

    public void setWeek_ending_date(Date week_ending_date) {
        this.week_ending_date = week_ending_date;
    }

    public String getCreated_by() {
        return created_by;
    }

    public void setCreated_by(String created_by) {
        this.created_by = created_by;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public String getUpdated_by() {
        return updated_by;
    }

    public void setUpdated_by(String updated_by) {
        this.updated_by = updated_by;
    }

    public Date getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(Date updated_at) {
        this.updated_at = updated_at;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getExpenses() {
        return expenses;
    }

    public void setExpenses(int expenses) {
        this.expenses = expenses;
    }

    public String getSubmitted_by() {
        return submitted_by;
    }

    public void setSubmitted_by(String submitted_by) {
        this.submitted_by = submitted_by;
    }

    public int getLock_version() {
        return lock_version;
    }

    public void setLock_version(int lock_version) {
        this.lock_version = lock_version;
    }

    public Date getSubmitted_at() {
        return submitted_at;
    }

    public void setSubmitted_at(Date submitted_at) {
        this.submitted_at = submitted_at;
    }
}
