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
    private String client_name;
    private String project_name;
    private String sub_project_name;

    public String getClient_name() {
        return client_name;
    }

    public void setClient_name(String client_name) {
        this.client_name = client_name;
    }

    public String getProject_name() {
        return project_name;
    }

    public void setProject_name(String project_name) {
        this.project_name = project_name;
    }

    public String getSub_project_name() {
        return sub_project_name;
    }

    public void setSub_project_name(String sub_project_name) {
        this.sub_project_name = sub_project_name;
    }
    @Column(name = "client")
    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    @Column(name = "project")
    public String getProject() {
        return project;
    }

    public void setProject(String project) {
        this.project = project;
    }

    @Column(name = "sub_project")
    public String getSub_project() {
        return sub_project;
    }

    public void setSub_project(String sub_project) {
        this.sub_project = sub_project;
    }







}
