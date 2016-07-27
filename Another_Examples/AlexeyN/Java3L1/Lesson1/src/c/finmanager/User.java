package c.finmanager;

import java.util.ArrayList;
import java.util.Set;

/**
 * Created by tomag on 10.07.2016.
 */
public class User {
    private final String login;
    private String password;
    private Set<Account> accountSet;

    public User(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Account> getAccountSet() {
        return accountSet;
    }

}
