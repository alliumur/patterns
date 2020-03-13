package pl.rmv.schat.context;

import pl.rmv.schat.Chat;
import pl.rmv.schat.repository.AccountRepository;

public class ApplicationContext {
    private static ApplicationContext appCntx           = null;
    private AccountRepository         accountRepository = null;
    private Chat chat              = null;

    private ApplicationContext() { }

    public static ApplicationContext getInstance() {
        if(appCntx == null) {
            appCntx = new ApplicationContext();
            appCntx.init();
        }
        return appCntx;
    }

    private void init() {
        accountRepository = new AccountRepository();
        chat = new Chat();
    }

    public AccountRepository getAccountRepository() {
        return accountRepository;
    }

    public Chat getChat() {
        return chat;
    }
}
