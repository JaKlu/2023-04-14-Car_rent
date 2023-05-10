package pl.camp.it.car.rent.db;

import pl.camp.it.car.rent.model.User;

import java.util.*;

public class UserRepository {
    private static final UserRepository instance = new UserRepository();
    private final Map<String, User> users = new HashMap<>();

    private UserRepository() {
    }

/*    public UserRepository() {
        this.users.put("admin", new User("admin", "6204e2eb5e6e506d909ffb65559a795f"));
        this.users.put("janusz", new User("janusz", "efa5a067ea40ad3e3309c115b9b82726"));
    }*/
    public void addUser(User user) {
        users.put(user.getLogin(), user);

    }

    public User findUserByLogin(String login) {
        return users.get(login);
    }

    public Collection<User> getUsers() {
        return this.users.values();
    }

    public static UserRepository getInstance() {
        return instance;
    }
}
