package pl.rmv.schat;

import pl.rmv.schat.context.ApplicationContext;
import pl.rmv.schat.model.Account;
import pl.rmv.schat.model.Message;
import pl.rmv.schat.model.Status;
import pl.rmv.schat.model.User;
import pl.rmv.schat.repository.AccountRepository;

import java.util.HashSet;
import java.util.Set;

public class Chat implements Observable{
    Set<Observer> observers = new HashSet<>();
    AccountRepository accountRepository = ApplicationContext.getInstance().getAccountRepository();

    public void registration(String name) {
        User user = new User(name);
        Account account = new Account(user, Status.OFFLINE);
        accountRepository.save(account);
        changeStatus(account, Status.ONLINE);
    }

    public void sendMessage(String name, String text) {
        Account account = accountRepository.findOne(name);
        if(account == null) return;

        for (Account item : accountRepository.findAll()) {
            if(item.getStatus() == Status.ONLINE) {
                item.addMessage(new Message(text, name));
            }
        }
        notifyObservers();
    }

    public void changeStatus(String name, Status status) {
        changeStatus(accountRepository.findOne(name), status);
    }

    private void changeStatus(Account account, Status status) {
        if(account == null) return;

        account.setStatus(status);
        if(status == Status.ONLINE) {
            attach(account);
        }else {
            detach(account);
        }
    }

    @Override
    public void attach(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void detach(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.showMessages();
        }
    }
}
