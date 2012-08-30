package com.thoughtworks.twu.service;

import com.thoughtworks.twu.domain.State;
import com.thoughtworks.twu.persistence.HibernateConnection;
import org.hibernate.Session;

import java.util.HashMap;
import java.util.List;

public class EmployeeService {

    private HibernateConnection connection;
    public Session session;

    private List<String> name;
    private List<State> states;
    private HashMap<String, List<State>> countryStates = new HashMap<String, List<State>>();

    public EmployeeService() {

        connection = HibernateConnection.getInstance();
        session = connection.getSession();

        name = session.createQuery("from com.thoughtworks.twu.domain.Employee").list();


    }
}
