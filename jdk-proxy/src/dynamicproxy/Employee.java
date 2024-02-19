package dynamicproxy;

public interface Employee {

    void giveHike(double amount);
    void payCut(double amount);

    void setId(int id);
    int getId();
    void setName(String name);
    String getName();

    void setSalary(double salary);

    double getSalary();
}
