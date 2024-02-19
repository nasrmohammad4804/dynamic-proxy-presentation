package dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class EmployeeSalaryInvocationHandler implements InvocationHandler {

    private final Employee target;

    public EmployeeSalaryInvocationHandler(Employee target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {


        if (method.getName().equals("giveHike") && args!=null && args.length>0){
            double amount =(double) args[0];
            if (amount<0)
                throw new RuntimeException("amount cant be negative while hiking his salary");
        }
        Object result = method.invoke(target,args);
        System.out.println("method with name of : "+method.getName()+" called with employee id : "+target.getId());

        return  result;
    }
}
