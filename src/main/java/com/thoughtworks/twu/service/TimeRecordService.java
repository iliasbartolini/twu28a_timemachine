package com.thoughtworks.twu.service;

import com.thoughtworks.twu.domain.Timesheet;
import com.thoughtworks.twu.domain.Timesheet;
import com.thoughtworks.twu.persistence.HibernateConnection;
import org.hibernate.Session;

import java.util.List;

public class TimeRecordService {

    private HibernateConnection connection;
    private Session session;

    public TimeRecordService() {
        connection = HibernateConnection.getInstance();
        session = connection.getSession();

    }

    public List<Timesheet> getTimeReportForUser(int timesheetID) {

        return session.createQuery("FROM com.thoughtworks.twu.domain.Time_reports WHERE TIME_SHEET_ID ='%" + timesheetID + "%'").list();
    }

    public void saveTimeRecord(Timesheet timesheet) {
        session.getTransaction().begin();
        session.save(timesheet);
        session.getTransaction().commit();
    }


}