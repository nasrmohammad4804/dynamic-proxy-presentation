package org.example.cglib;

import net.sf.cglib.proxy.Enhancer;

public class Main {
    public static void main(String[] args) {


        Printer printerProxy = createProxy(Printer.class);
        printerProxy.print();
    }
    @SuppressWarnings("unchecked")
    public static <T> T createProxy(Class<T> clazz){
        Enhancer enhancer = new Enhancer();

        enhancer.setSuperclass(clazz);
        enhancer.setCallback(new CustomInvocationHandler());


        return  (T) enhancer.create();
    }
}
