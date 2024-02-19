package org.example.jdk;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserServiceImpl implements UserService {

    /*
    instead of save user in db save in memory
    *
    */
    private final List<User> list = new ArrayList<>();

    @Override
    @CustomTransaction
    public void addUser(User user) {
        list.add(user);
        System.out.println(user.getName() + " is added successfully");
    }

    @Override
    public User getById(Long id) {

        return list.stream().filter(user -> user.getId().equals(id))
                .findAny()
                .orElseThrow(() -> new UserNotFoundException("dont find any user with id : " + id));

    }
}
