package pl.rmv.schat.model;

import pl.rmv.schat.Observer;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class Account implements Observer {
    private User user;
    private Status status;
    private List<Message> messages;
    private SimpleDateFormat formatter;

    public Account(User user, Status status) {
        super();
        this.user   = user;
        this.status = status;

        messages  = new ArrayList<>();
        formatter = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
    }

    public void addMessage(Message message) {
        messages.add(message);
    }

    public User getUser() {
        return user;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public void showMessages() {
        System.out.println(">>>>>>>>>>>>>> EKRAN - " + user.getName());
        for (Message message : messages) {
            System.out.println("[" + formatter.format(message.getDate()) + "] " +
                    message.getSender()+ ": " + message.getText());
        }
        System.out.println();
    }
}
