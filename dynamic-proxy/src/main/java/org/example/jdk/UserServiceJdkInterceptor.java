package org.example.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Optional;
import java.util.logging.Logger;

public class UserServiceJdkInterceptor<T> implements InvocationHandler {
    private final T realService;

    private Logger logger = Logger.getLogger(UserServiceJdkInterceptor.class.getSimpleName());

    public UserServiceJdkInterceptor(T realService) {
        this.realService = realService;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        logger.info("request intercepted for method : " + method.getName());

        Class<?>[] array = Arrays.stream(args).map(Object::getClass)
                .toArray(Class[]::new);

        Method actualMethod = realService.getClass().getMethod(method.getName(), array);
        CustomTransaction annotation = actualMethod.getAnnotation(CustomTransaction.class);


        if (!Optional.ofNullable(annotation).isPresent())
            return method.invoke(realService, args);

        else {
            Object result = null;

            try {

                EntityTransaction.begin();
                logger.info("transaction started !");

                result = method.invoke(realService, args);

                EntityTransaction.commit();
                logger.info("transaction committed successfully !");

            } catch (Exception e) {

                logger.warning("transaction cant to complete");
                EntityTransaction.rollback();
            }
            return result;
        }

    }
}
