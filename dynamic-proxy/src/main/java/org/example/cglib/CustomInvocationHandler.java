package org.example.cglib;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;


public class CustomInvocationHandler implements MethodInterceptor {

    @Override
    public Object intercept(Object o, Method method, Object[] arguments, MethodProxy methodProxy) throws Throwable {

        System.out.println("logic need before method call");
        Object object = methodProxy.invokeSuper(o, arguments);

        System.out.println("logic need after method call");
        return  object;
    }
}
