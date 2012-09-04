package com.thoughtworks.twu.domain;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Date;


@Entity
@Table( name = "time_sheets" )
public class Timesheet {
    public int id;

    @Id
    @GeneratedValue(generator="id")
    @GenericGenerator(name="id", strategy = "increment")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private String employee_decimal;
    private Date week_ending_date;
    private String created_by;
    private Date created_at;
    private String updated_by;
    private Date updated_at;

    public String getEmployee_decimal() {
        return employee_decimal;
    }

    public void setEmployee_decimal(String employee_decimal) {
        this.employee_decimal = employee_decimal;
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


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Timesheet timesheet = (Timesheet) o;

        if (id != timesheet.id) return false;
        if (employee_decimal != null ? !employee_decimal.equals(timesheet.employee_decimal) : timesheet.employee_decimal != null)
            return false;
        if (week_ending_date != null ? !week_ending_date.equals(timesheet.week_ending_date) : timesheet.week_ending_date != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (employee_decimal != null ? employee_decimal.hashCode() : 0);
        result = 31 * result + (week_ending_date != null ? week_ending_date.hashCode() : 0);
        return result;
    }
}
