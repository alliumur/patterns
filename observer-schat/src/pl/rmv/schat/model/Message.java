package pl.rmv.schat.model;

import java.util.Date;

public class Message {
    private String text;
    private Date date;
    private String sender;

    public Message(String text, String sender) {
        this.text =  text;
        this.sender = sender;
        date = new Date();
    }

    public String getText() {
        return text;
    }

    public Date getDate() {
        return date;
    }

    public String getSender() {
        return sender;
    }
}
