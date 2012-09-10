package com.thoughtworks.twu.domain;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;


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

    private Date weekEndingDate;

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

    @Column(name = "WEEK_ENDING_DATE")
    public Date getWeekEndingDate() {
        return weekEndingDate;
    }

    public void setWeekEndingDate(Date weekEndingDate) {
        this.weekEndingDate = weekEndingDate;
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
        if (weekEndingDate != null ? !weekEndingDate.equals(timesheet.weekEndingDate) : timesheet.weekEndingDate != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (employee_decimal != null ? employee_decimal.hashCode() : 0);
        result = 31 * result + (weekEndingDate != null ? weekEndingDate.hashCode() : 0);
        return result;
    }
}
