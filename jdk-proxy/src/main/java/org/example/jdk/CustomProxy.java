package org.example.jdk;

import java.lang.reflect.InvocationHandler;

public class CustomProxy implements UserService{

    private final InvocationHandler interceptor;

    public CustomProxy(InvocationHandler interceptor) {
        this.interceptor = interceptor;
    }

    @Override
    public void addUser(User user) throws Throwable {
        interceptor.invoke(this,UserService.class.getMethod("addUser", User.class),
                new Object[] {user});
    }

    @Override
    public User getById(Long id) throws Throwable {
        return (User) interceptor.invoke(this,UserService.class.getMethod("getById", Long.class),new Object[] {id});
    }

}
