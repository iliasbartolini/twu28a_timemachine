package com.thoughtworks.twu.persistence; /**
 * Created with IntelliJ IDEA.
 * User: shilpa
 * Date: 8/23/12
 * Time: 12:07 PM
 * To change this template use File | Settings | File Templates.
 */

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.json.JSONException;


public class HibernateConnection {

    private static HibernateConnection instance;
    private Session session;
    private SessionFactory sessionFactory;

    public static HibernateConnection getInstance() {
        if ( instance == null )
            instance = new HibernateConnection();

        return instance;
    }

    private HibernateConnection() {
        configDb();
    }

    private void configDb() {
        Configuration configuration = new Configuration().configure();
        ServiceRegistry service = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
        sessionFactory = configuration.buildSessionFactory(service);
        session = sessionFactory.openSession();
    }

    public Session getSession() {
        return session;
    }
}