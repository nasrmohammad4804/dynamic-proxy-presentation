package dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class Client {
    public static void main(String[] args) {

        Employee employee = new ITEmployee(4000);
        employee.setId(1);
        employee.setName("jake");

        InvocationHandler handler= new EmployeeSalaryInvocationHandler(employee);

        /*
        * 3 parameter needed
        * 1.  class loader is used to specify class loader that will be responsible for loading dynamically generated proxy class
        * different type of class loader in java
        *   bootstrap class loader : load core java classes
        *   extension class loader : load class from the java extension directory
        *   Application class loader : load class from the application class path
        *
        * 2. list of class name of interface . those are interface that need to be implemented by proxy object
        * 3. invocation handler as interceptor we use this for delegate functionality to this class
        * */


        // for achieve current class loader (becasue Client.java is custom class that we sue application class loader used)

        ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();

        Employee proxyEmployee  =(Employee) Proxy.newProxyInstance(
                contextClassLoader,
                new Class<?>[] {Employee.class},
                handler
        );
        proxyEmployee.giveHike(2300);
        System.out.println(proxyEmployee.getSalary());
    }
}
