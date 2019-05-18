package ru.nikitaboiko.patterns.users;

import java.util.HashMap;
import java.util.Map;

public class IdentityMapUsers {
    private static IdentityMapUsers instance;
    final Map<String, User> userList = new HashMap();

    private IdentityMapUsers() {
    }

    public static synchronized IdentityMapUsers getInstance() {
        if (instance == null) {
            instance = new IdentityMapUsers();
        }
        return instance;
    }

    public Map getUserList() {
        return userList;
    }

    public User checkUser(String name) {
        return userList.get(name);
    }
}
