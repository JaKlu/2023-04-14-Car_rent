package pl.camp.it.car.rent.db;

import pl.camp.it.car.rent.model.User;

import java.util.*;

public class UserRepository {
    private final Map<String, User> users = new HashMap<>();

    public UserRepository() {
        this.users.put("admin", new User("admin", "6204e2eb5e6e506d909ffb65559a795f"));
        this.users.put("janusz", new User("janusz", "efa5a067ea40ad3e3309c115b9b82726"));
    }

    public User findUserByLogin(String login) {
        /*for (User user : users) {
            if (user.getLogin().equals(login))
                return user;
        }
        return null;*/
        return users.get(login);
    }

    public Collection<User> getUsers() {
        return this.users.values();
    }
}
