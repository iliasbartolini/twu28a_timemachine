package com.thoughtworks.twu.service;

import com.thoughtworks.twu.domain.Message;
import com.thoughtworks.twu.persistence.HibernateConnection;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import java.util.List;


public class MessageService {

    private HibernateConnection connection;
    private Session session;

    public MessageService() {
        connection = HibernateConnection.getInstance();
        session = connection.getSession();

    }
    public List<Message> getAllMessages() {
        return session.createQuery("from com.thoughtworks.twu.domain.Message").list();
    }
    public String getMessageForField(int index)
    {
        List<Message>  messages = getAllMessages();
        return messages.get(index).getMessage();
    }

    public Message getMessageMessageById(String messageId) {
        return (Message) session.createCriteria(Message.class).
                add(Restrictions.eq("messageId", messageId)).list().get(0);
    }
}
