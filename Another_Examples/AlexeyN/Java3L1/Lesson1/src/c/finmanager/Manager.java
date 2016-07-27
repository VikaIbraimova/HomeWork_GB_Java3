package c.finmanager;

import java.util.HashMap;
import java.util.Set;

/**
 * Created by tomag on 10.07.2016.
 */
public class Manager implements DataStore {

    private HashMap<String,User> userDatabase = new HashMap<>();

    public void regUser(String login, String password) {
        if (login.length()>5 && password.length()>5) {
            userDatabase.put(login,new User(login,password));
        }
    }

    @Override
    public User getUser(String name) {
        return userDatabase.containsKey(name) ? userDatabase.get(name) : null;
    }

    @Override
    public Set<String> getUserNames() {
        return userDatabase.keySet();
    }

    @Override
    public Set<Account> getAccounts(User owner) {
        return owner.getAccountSet();
    }

    @Override
    public Set<Record> getRecords(Account account) {
        return account.getRecordSet();
    }

    @Override
    public void addUser(User user) {
        userDatabase.put(user.getLogin(),user);
    }

    @Override
    public void addAccount(User user, Account account) {
        user.getAccountSet().add(account);
    }

    @Override
    public void addRecord(Account account, Record record) {
        account.getRecordSet().add(record);
    }

    @Override
    public User removeUser(String name) {
        if (userDatabase.containsKey(name)) {
            userDatabase.remove(name);
        }
        return null;
    }

    @Override
    public Account removeAccount(User owner, Account account) {
        if (owner.getAccountSet().contains(account)) {
            owner.getAccountSet().remove(account);
        }
        return null;
    }

    @Override
    public Record removeRecord(Account from, Record record) {
        if (from.getRecordSet().contains(record)) {
            from.getRecordSet().remove(record);
        }
        return null;
    }
}
