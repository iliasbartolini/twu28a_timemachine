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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Time_Sheets that = (Time_Sheets) o;

        if (expenses != that.expenses) return false;
        if (id != that.id) return false;
        if (lock_version != that.lock_version) return false;
        if (created_at != null ? !created_at.equals(that.created_at) : that.created_at != null) return false;
        if (created_by != null ? !created_by.equals(that.created_by) : that.created_by != null) return false;
        if (employee_number != null ? !employee_number.equals(that.employee_number) : that.employee_number != null)
            return false;
        if (status != null ? !status.equals(that.status) : that.status != null) return false;
        if (submitted_at != null ? !submitted_at.equals(that.submitted_at) : that.submitted_at != null) return false;
        if (submitted_by != null ? !submitted_by.equals(that.submitted_by) : that.submitted_by != null) return false;
        if (updated_at != null ? !updated_at.equals(that.updated_at) : that.updated_at != null) return false;
        if (updated_by != null ? !updated_by.equals(that.updated_by) : that.updated_by != null) return false;
        if (week_ending_date != null ? !week_ending_date.equals(that.week_ending_date) : that.week_ending_date != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (employee_number != null ? employee_number.hashCode() : 0);
        result = 31 * result + (week_ending_date != null ? week_ending_date.hashCode() : 0);
        result = 31 * result + (created_by != null ? created_by.hashCode() : 0);
        result = 31 * result + (created_at != null ? created_at.hashCode() : 0);
        result = 31 * result + (updated_by != null ? updated_by.hashCode() : 0);
        result = 31 * result + (updated_at != null ? updated_at.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + expenses;
        result = 31 * result + (submitted_by != null ? submitted_by.hashCode() : 0);
        result = 31 * result + lock_version;
        result = 31 * result + (submitted_at != null ? submitted_at.hashCode() : 0);
        return result;
    }
}
