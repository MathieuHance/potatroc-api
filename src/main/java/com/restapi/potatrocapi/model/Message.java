package com.restapi.potatrocapi.model;

import javax.persistence.*;

@Entity
@Table(name = "message", schema = "potatroc")
public class Message extends InfoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "message_id")
    private long message_id;

    @Column(name = "body")
    private String body;

    @Column(name = "read")
    private boolean read;

    @ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL )
    @JoinColumn(name = "conversation_message_id")
    private Conversation conversation;

    @ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL )
    @JoinColumn(name = "serder_message_id")
    private User sender;

    public Message() {
    }

    public Message ( String body, boolean read, Conversation conversation){
        this.body = body;
        this.read = read;
        this.conversation = conversation;
    }

    public long getMessage_id() {
        return message_id;
    }

    public void setMessage_id(long message_id) {
        this.message_id = message_id;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public boolean getRead() {
        return read;
    }

    public void setRead(boolean read) {
        this.read = read;
    }

    public Conversation getConversation() {
        return conversation;
    }

    public void setConversation(Conversation conversation) {
        this.conversation = conversation;
    }

    public long getSender() {
        return sender.getId();
    }

    public void setSender(User sender) {
        this.sender = sender;
    }
}
