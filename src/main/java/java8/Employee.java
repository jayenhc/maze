package java8;

import java.util.ArrayList;
import java.util.List;

public class Employee {
    public int id;
    public String firstName;
    public String lastName;
    public int sal;

    public Employee(int id, String firstName, String lastName, int sal) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.sal = sal;
    }

    public static List<Employee> getEmpList() {
        List<Employee> list = new ArrayList<>();
        list.add(new Employee(1, "A", "AL", 2000));
        list.add(new Employee(2, "B", "BL", 3000));
        list.add(new Employee(3, "C", "CL", 4000));
        list.add(new Employee(4, "D", "DL", 5000));
        return list;
    }
}
