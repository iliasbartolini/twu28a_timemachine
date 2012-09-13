package com.thoughtworks.twu.service;

import com.thoughtworks.twu.domain.Timesheet;
import com.thoughtworks.twu.persistence.HibernateConnection;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Service;

import java.util.Date;
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

    public long saveTimesheet(Timesheet timesheet) {
        connection = HibernateConnection.getInstance();
        session = connection.getSession();

        session.getTransaction().begin();
        Date today = new Date(System.currentTimeMillis());

        timesheet.setUpdatedAt(today);
        timesheet.setCreatedAt(today);
        session.saveOrUpdate(timesheet);
        long timesheetID = timesheet.getId();
        session.getTransaction().commit();
        session.close();
        return timesheetID;
    }

    public Timesheet createNewTimesheet() {
        connection = HibernateConnection.getInstance();
        session = connection.getSession();
        session.getTransaction().begin();
        Timesheet timesheet = new Timesheet();
        session.saveOrUpdate(timesheet);
        session.getTransaction().commit();
        session.close();
        return timesheet;
    }

    public List<Timesheet> getAllTimesheetsByUser(String remoteUser) {
        connection = HibernateConnection.getInstance();
        session = connection.getSession();
        return session.createCriteria(Timesheet.class)
                .add(Restrictions.eq("employeeNumber", remoteUser)).addOrder(Order.desc("weekEndingDate")).list();
    }

    public Timesheet getTimeSheetById(int timesheetId) {
        connection = HibernateConnection.getInstance();
        session = connection.getSession();
        return (Timesheet)session.get(Timesheet.class, timesheetId);


    }

    public Timesheet createTimesheetIfNotExists(String timesheetId) {
        if ( timesheetId.isEmpty() ) {
             return createNewTimesheet();
        }

        return getTimeSheetById(Integer.parseInt(timesheetId));
    }
}
