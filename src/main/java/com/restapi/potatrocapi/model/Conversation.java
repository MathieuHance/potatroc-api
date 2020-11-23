package com.restapi.potatrocapi.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "conversation", schema = "potatroc")
public class Conversation extends InfoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "conversation_id")
    private long conversation_id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_coneversation_one_id")
    private User user_one;

    @ManyToOne(fetch = FetchType.EAGER )
    @JoinColumn(name = "user_coneversation_two_id")
    private User user_two;

    @OneToMany(fetch = FetchType.EAGER , mappedBy = "conversation")
    @JsonIgnoreProperties("conversation")
    private List<Message> messages;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "crop_conversation_id")
    private Crop crop;


    public Conversation() {
    }

    public Conversation ( User user_one, User user_two, List<Message> messages, Crop crop){
        this.user_one = user_one;
        this.user_two = user_two;
        this.messages = messages;
        this.crop = crop;
    }

    public long getUser_one() {
        return user_one.getId();
    }

    public void setUser_one(User user_one) {
        this.user_one = user_one;
    }

    public long getUser_two() {
        return user_two.getId();
    }

    public void setUser_two(User user_two) {
        this.user_two = user_two;
    }

    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }

    public long getCrop() {
        return crop.getId();
    }

    public void setCrop(Crop crop) {
        this.crop = crop;
    }
}
