package com.thoughtworks.twu.service;

import com.thoughtworks.twu.domain.Message;
import com.thoughtworks.twu.domain.Time_Records;
import com.thoughtworks.twu.domain.Time_Sheets;
import com.thoughtworks.twu.persistence.HibernateConnection;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: ewonou
 * Date: 4/9/12
 * Time: 2:44 PM
 * To change this template use File | Settings | File Templates.
 */
public class DraftTimesheetService {
    private HibernateConnection connection;
    private Session session;

    public DraftTimesheetService() {
        connection = HibernateConnection.getInstance();
        session = connection.getSession();
    }

    public List<Message> getDrafts() {
        return session.createQuery("from com.thoughtworks.twu.domain.").list();
    }


}
