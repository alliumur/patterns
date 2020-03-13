package pl.rmv.schat.db;

import pl.rmv.schat.model.Account;

import java.util.ArrayList;
import java.util.List;

public class Database {
    private static List<Account> accounts = new ArrayList<>();

    public static List<Account> getAccounts() {
        return accounts;
    }
}
