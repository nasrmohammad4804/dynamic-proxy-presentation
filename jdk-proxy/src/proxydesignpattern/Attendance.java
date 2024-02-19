package proxydesignpattern;

import java.time.LocalDate;

public class Attendance {

    private LocalDate date;
    private  boolean isPresent;

    public Attendance(LocalDate date, boolean isPresent) {
        this.date = date;
        this.isPresent = isPresent;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public boolean isPresent() {
        return isPresent;
    }

    public void setPresent(boolean present) {
        isPresent = present;
    }
}
