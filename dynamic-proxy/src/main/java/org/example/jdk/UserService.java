package org.example.jdk;

public interface UserService {

    void addUser(User user) throws Throwable;

    User getById(Long id) throws Throwable;
}
