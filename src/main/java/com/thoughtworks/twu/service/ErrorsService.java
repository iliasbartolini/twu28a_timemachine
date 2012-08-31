package com.thoughtworks.twu.service;

import com.thoughtworks.twu.domain.Activity;
import com.thoughtworks.twu.persistence.HibernateConnection;
import org.hibernate.Session;

import java.util.List;


/**
 * Created with IntelliJ IDEA.
 * User: ewonou
 * Date: 31/8/12
 * Time: 11:16 AM
 * To change this template use File | Settings | File Templates.
 */
public class ErrorsService {
    HibernateConnection connection;
    Session session;


    public List<Activity> getAllErrors() {
        return session.createQuery("from com.thoughtworks.twu.domain.Errors ").list();
    }

}
