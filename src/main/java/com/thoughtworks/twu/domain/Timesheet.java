package com.thoughtworks.twu.domain;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;


@Entity
@Table( name = "time_sheets" )
public class Timesheet {
    public int id;
    private String employeeNumber;
    private Date weekEndingDate;
    private String created_by; //Fill
    private Date createdAt;
    private String updated_by; //Fill
    private Date updatedAt;

    @Id
    @GeneratedValue(generator="id")
    @GenericGenerator(name="id", strategy = "increment")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name="employee_number")
    public String getEmployeeNumber() {
        return employeeNumber;
    }

    public void setEmployeeNumber(String employeeNumber) {
        this.employeeNumber = employeeNumber;
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

    @Column(name= "created_at")
    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdated_by() {
        return updated_by;
    }

    public void setUpdated_by(String updated_by) {
        this.updated_by = updated_by;
    }

    @Column(name = "updated_at")
    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Timesheet timesheet = (Timesheet) o;

        if (id != timesheet.id) return false;
        if (employeeNumber != null ? !employeeNumber.equals(timesheet.employeeNumber) : timesheet.employeeNumber != null)
            return false;
        if (weekEndingDate != null ? !weekEndingDate.equals(timesheet.weekEndingDate) : timesheet.weekEndingDate != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (employeeNumber != null ? employeeNumber.hashCode() : 0);
        result = 31 * result + (weekEndingDate != null ? weekEndingDate.hashCode() : 0);
        return result;
    }
}
