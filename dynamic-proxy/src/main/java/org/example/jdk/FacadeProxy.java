package org.example.jdk;

import java.lang.reflect.InvocationHandler;

public class FacadeProxy {

    public static CustomProxy createNewInstance(Class<?>[] interfaces, InvocationHandler interceptor){
        return  new CustomProxy(interceptor);
    }
}
