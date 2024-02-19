package proxydesignpattern;

public class Student implements DailySession {

    protected Attendance attendance;

    public Student(){

    }
    public Student(Attendance attendance) {
        this.attendance = attendance;
    }

    @Override
    public void attendLesson() {

        System.out.println("student attended");
    }
    private void attendLesson(int id){
        System.out.println("attending the session with id : "+id);
    }

    public Attendance getAttendance() {
        return attendance;
    }

    public void setAttendance(Attendance attendance) {
        this.attendance = attendance;
    }
}
