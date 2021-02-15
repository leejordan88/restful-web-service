package com.example.restfulwebservice.user;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class UserDaoService {

    private static List<User> USERS = new ArrayList<>();
    private static int USER_COUNT = 3;

    static {
        USERS.add(new User(1, "joonsung", new Date()));
        USERS.add(new User(2, "alice", new Date()));
        USERS.add(new User(3, "jordan", new Date()));
    }

    public List<User> findAll() {
        return USERS;
    }

    public Optional<User> findById(int id) {
        return USERS.stream()
                .filter(u -> u.getId() == id)
                .findFirst()
                ;
    }

    public User save(User user) {
        if (user.getId() == null) {
            user.setId(++USER_COUNT);
        }
        USERS.add(user);
        return user;
    }

    public Optional<User> deleteById(int id) {
        Optional<User> byId = findById(id);
        if (byId.isPresent()) {
            User user = byId.get();
            USERS.remove(user);
        }
        return byId;
    }
}
