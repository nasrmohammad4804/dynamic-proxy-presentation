package dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class Client {
    public static void main(String[] args) {

        Employee employee = new ITEmployee(4000);
        employee.setId(1);
        employee.setName("jake");

        InvocationHandler handler= new EmployeeSalaryInvocationHandler(employee);

        Employee proxyEmployee  =(Employee) Proxy.newProxyInstance(
                Employee.class.getClassLoader(),
                new Class<?>[] {Employee.class},
                handler
        );
        proxyEmployee.giveHike(2300);
        System.out.println(proxyEmployee.getSalary());
    }
}
