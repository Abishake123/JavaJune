package EmployeeEncapsulation;

import java.util.ArrayList;

public class App {

    ArrayList<Employee> employees = new ArrayList<>();

    public static void main(String[] args) {

        App app = new App();

        app.dataCreation();

        // app.employees.get(0).salary = -9000l;

        System.out.println(app.employees);

    }

    public void dataCreation() {
        Employee employee = new Employee();
        employee.name = "Jhon";
        employee.role = "Dev";
        // employee.salary = 200000l;

        employee.setSalary(200000l, "HR");

        employees.add(employee);

        employee = new Employee();
        employee.name = "Alex";
        employee.role = "QA";
        // employee.salary = 100000l;

        employee.setSalary(150000l, "DEV");

        employees.add(employee);
    }

}
