package org.example.jdk;

import java.lang.reflect.Proxy;

public class Main {
    public static void main(String[] args) throws Throwable {

        /*
        approach 1
        *
        * */

        UserService userService  = new UserServiceImpl();
        UserService proxyUserService = createProxy(userService,UserService.class);
        proxyUserService.addUser(new User(1L,"mohammad"));

        System.out.println(proxyUserService.getById(1L));


        /*
        approach 2
        *
        */
/*        InvocationHandler interceptor = new UserServiceJdkInterceptor<>(userService);
        UserService proxyUserService = FacadeProxy.createNewInstance(new Class[] {UserService.class},interceptor);
        proxyUserService.addUser(new User("mohammad"));*/


    }

    @SuppressWarnings("unchecked")
    public static <T> T createProxy(T target, Class<? super T> interfaceType){

        UserServiceJdkInterceptor<T> interceptor = new UserServiceJdkInterceptor<>(target);

        return (T) Proxy.newProxyInstance(
                interfaceType.getClassLoader(),
                new Class <?>[] {interfaceType},
                interceptor
        );
    }
}
