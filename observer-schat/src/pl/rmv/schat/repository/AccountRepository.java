package pl.rmv.schat.repository;

import pl.rmv.schat.db.Database;
import pl.rmv.schat.model.Account;

import java.util.List;

public class AccountRepository implements Repository<Account> {

    List<Account> accounts = Database.getAccounts();

    @Override
    public <S extends Account> S save(S entity) {
        accounts.add(entity);
        return entity;
    }

    public List<Account> findAll() {
        return accounts;
    }

    public Account findOne(String name) {
        return accounts.stream().filter(a -> a.getUser().getName().equals(name)).findFirst().orElse(null);
    }

    @Override
    public Account findOne(Account account) {
        return accounts.stream().filter(a -> a == account).findFirst().orElse(null);
    }

    @Override
    public Long count() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void delete(Account entity) {
        // TODO Auto-generated method stub
    }
}
