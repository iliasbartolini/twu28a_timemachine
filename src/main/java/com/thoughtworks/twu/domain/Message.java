package com.thoughtworks.twu.domain;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table( name = "messages" )
public class Message {
    @Id
    @GeneratedValue(generator="id")
    @GenericGenerator(name="id", strategy = "increment")
    private int id;
    private String message;

    @Column(name = "message_id")
    private String messageId;

    public Message(String message, String messageId) {
        this.message = message;
        this.messageId = messageId;
    }

    public Message() {
    }

    public String getMessage() {
        return message;
    }

    public String getMessageId() {
        return messageId;
    }
}
