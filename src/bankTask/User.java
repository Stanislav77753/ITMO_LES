package bankTask;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * Created by Stas on 23.05.2018.
 */
public class User {
    private final int id;
    private String email;
    private List<Account> listAccoutn = new LinkedList<>();

    public User(int id, String email){
        this.id = id;
        this.email = email;
    }

    public void addAccount(Account account){
        listAccoutn.add(account);
    }

    public Account getListAccoutn(int idAccount) {
        return listAccoutn.get(idAccount - 1);
    }




}
