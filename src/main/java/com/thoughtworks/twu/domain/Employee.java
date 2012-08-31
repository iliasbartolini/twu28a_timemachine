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

    public void setId(int id) {
        this.id = id;
    }

    private String name;

    public void setName(String name) {
        this.name = name;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    private String login;

    @Id
    @GeneratedValue(generator = "id")
    @GenericGenerator(name = "id", strategy = "increment")
    public int getId() {
        return id;
    }


    public String getName() {
        return name;
    }

    public String getLogin() {
        return login;
    }


}
