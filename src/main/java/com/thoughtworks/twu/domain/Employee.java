package com.thoughtworks.twu.domain;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;




@Entity
@Table(name = "employees")
public class Employee {


    private int id;
    private String name;
    private String login;
    private String employee_decimal;

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

    public String getEmployee_decimal() {
        return employee_decimal;
    }

    public void setEmployee_decimal(String employee_decimal) {
        this.employee_decimal = employee_decimal;
    }






    public String getName() {
        return name;
    }

    public String getLogin() {
        return login;
    }


}
