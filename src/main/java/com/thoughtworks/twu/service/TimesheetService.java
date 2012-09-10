package com.thoughtworks.twu.service;

import com.thoughtworks.twu.domain.Timesheet;
import com.thoughtworks.twu.persistence.HibernateConnection;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TimesheetService {


    private HibernateConnection connection;
    private Session session;

    public TimesheetService() {
        connection = HibernateConnection.getInstance();
        session = connection.getSession();

    }

    public List<Timesheet> getAllTimesheets() {

        connection = HibernateConnection.getInstance();
        session = connection.getSession();

        return session.createCriteria(Timesheet.class)
                .list();
    }

    public void saveTimesheet(Timesheet timesheet) {
        connection = HibernateConnection.getInstance();
        session = connection.getSession();

        session.getTransaction().begin();
        session.save(timesheet);
        session.getTransaction().commit();
        session.close();
    }

    public Timesheet createNewTimesheet() {
        connection = HibernateConnection.getInstance();
        session = connection.getSession();
        session.getTransaction().begin();
        Timesheet timesheet = new Timesheet();
        session.save(timesheet);
        session.getTransaction().commit();

        return timesheet;
    }

    public List<Timesheet> getAllTimesheetsByUser(String remoteUser) {
        connection = HibernateConnection.getInstance();
        session = connection.getSession();

        return session.createCriteria(Timesheet.class)
                .add(Restrictions.eq("employeeNumber", remoteUser)).list();
    }
}
