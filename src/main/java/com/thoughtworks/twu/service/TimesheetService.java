package com.thoughtworks.twu.service;

import com.thoughtworks.twu.domain.Timesheet;
import com.thoughtworks.twu.persistence.HibernateConnection;
import org.hibernate.Session;

import java.util.List;

public class TimesheetService {


    private HibernateConnection connection;
    private Session session;

    public TimesheetService() {
        connection = HibernateConnection.getInstance();
        session = connection.getSession();

    }



    public List<Timesheet> getAllTimesheets() {
        return session.createQuery("from com.thoughtworks.twu.domain.Timesheet").list();
    }

    public void saveTimesheet(Timesheet timesheet) {
        session.getTransaction().begin();
        session.save(timesheet);
        session.getTransaction().commit();
    }


    public Timesheet addNewTimeSheet() {

        session.getTransaction().begin();
        Timesheet timesheet = new Timesheet();
        session.save(timesheet);
        session.getTransaction().commit();

        return timesheet;

    }
}
