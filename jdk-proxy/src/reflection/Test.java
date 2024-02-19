package reflection;

import proxydesignpattern.Student;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

public class Test {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException {

        Class<?> studentInfo = Class.forName("proxydesignpattern.Student");

        Student student =(Student) studentInfo.getDeclaredConstructor().newInstance();

        System.out.println(Arrays.toString(studentInfo.getConstructors()));
        System.out.println(Arrays.toString(studentInfo.getDeclaredMethods()));
        System.out.println(Arrays.toString(studentInfo.getMethods()));

        Method attendLessonMethod = studentInfo.getDeclaredMethod("attendLesson", int.class);
        attendLessonMethod.setAccessible(true);
        attendLessonMethod.invoke(student,23);


    }
}
