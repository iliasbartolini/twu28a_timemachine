package com.thoughtworks.twu.domain;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;


@Entity
@Table(name = "employees")
public class Employee {


    private int id;
    private String name;
    private String login;
    private String employeeNumber;

    @Id
    @GeneratedValue(generator = "id")
    @GenericGenerator(name = "id", strategy = "increment")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    @Column(name = "employee_number")
    public String getEmployeeNumber() {
        return employeeNumber;
    }

    public void setEmployeeNumber(String employeeNumber) {
        this.employeeNumber = employeeNumber;
    }


    public String getName() {
        return name;
    }

    public String getLogin() {
        return login;
    }


}
