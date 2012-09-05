package com.thoughtworks.twu.service;

import com.thoughtworks.twu.domain.Activity;
import com.thoughtworks.twu.persistence.HibernateConnection;
import org.hibernate.Session;

import java.util.List;



public class ErrorsService {
    HibernateConnection connection;
    Session session;


    public List<Activity> getAllErrors() {
        return session.createQuery("from com.thoughtworks.twu.domain.Errors ").list();
    }

}
