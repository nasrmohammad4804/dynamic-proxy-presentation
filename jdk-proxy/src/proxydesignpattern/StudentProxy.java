package proxydesignpattern;

import java.lang.reflect.Constructor;

public class StudentProxy extends Student{

    public StudentProxy(Attendance attendance) {
        super(attendance);
    }

    @Override
    public void attendLesson() {

        if (attendance != null && attendance.isPresent())
            super.attendLesson();

        throw  new RuntimeException("student not presented");
    }
}
class DynamicInstantiationExample {

    public static void main(String[] args) {
        String className = "DynamicClass"; // Replace with the actual class name

        try {
            // Load the class dynamically
            Class<?> dynamicClass = Class.forName(className);

            // Get the constructor with a String parameter
            Constructor<?> constructor = dynamicClass.getDeclaredConstructor(String.class);

            // Create an instance of the class with a specific message
            Object dynamicObject = constructor.newInstance("Hello, dynamic instantiation!");

            // Now you can work with the dynamically created object
            System.out.println("Dynamic object created: " + dynamicObject);

        } catch (ClassNotFoundException | NoSuchMethodException | InstantiationException |
                 IllegalAccessException | java.lang.reflect.InvocationTargetException e) {
            System.out.println(e.getMessage());
        }
    }
}