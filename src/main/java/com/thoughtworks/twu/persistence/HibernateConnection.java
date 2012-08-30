package com.thoughtworks.twu.persistence;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;


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
