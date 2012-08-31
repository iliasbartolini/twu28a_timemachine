package com.thoughtworks.twu.domain;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;


@Entity
@Table( name = "activities" )
public class Activity {
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


    private String client;
    private String project;
    private String sub_project;

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
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







}
