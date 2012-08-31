package com.thoughtworks.twu.service;

import com.thoughtworks.twu.domain.Activity;
import com.thoughtworks.twu.persistence.HibernateConnection;
import org.hibernate.Session;

import java.util.List;

public class ActivityService {

    private HibernateConnection connection;
    private Session session;

    public ActivityService() {
        connection = HibernateConnection.getInstance();
        session = connection.getSession();

    }

    public List<Activity> getAllActivities() {
        return session.createQuery("from com.thoughtworks.twu.domain.Activity").list();
    }

    public List<Activity> getActivities(String searchCriteria) {
        searchCriteria = searchCriteria.toLowerCase();
        return session.createQuery("from com.thoughtworks.twu.domain.Activity where lower (client) like '%" + searchCriteria + "%' or lower (project) like '%" + searchCriteria + "%' or lower (sub_project) like '%" + searchCriteria + "%'").list();
    }


}
