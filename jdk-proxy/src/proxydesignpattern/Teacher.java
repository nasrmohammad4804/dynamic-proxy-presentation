package proxydesignpattern;

import java.time.LocalDate;

public class Teacher {
    public static void main(String[] args) {

/*        Student student = new Student(new Attendance(LocalDate.now(), false));
        student.attendLesson();*/


        Student student = new StudentProxy(new Attendance(LocalDate.now(),false));
        student.attendLesson();
    }
}
