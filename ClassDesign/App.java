package ClassDesign;

import java.util.ArrayList;

public class App {

    public static void main(String[] args) {

        ArrayList<Integer> numb = new ArrayList<>();

        // [2,2]

        numb.add(2);
        numb.add(2);

        ArrayList<Employee> employees = new ArrayList<>();

       // []

        Employee employee = new Employee();

        employee.empId = 101;
        employee.name = "Jhon";
        employee.salary = 25000.00;

        employees.add(employee);

        employee = new Employee();

        employee.empId = 102;
        employee.name = "Alex";
        employee.salary = 27000.00;

        employees.add(employee);

        employee = new Employee();

        employee.empId = 103;
        employee.name = "Vishvi";
        employee.salary = 30000.00;

        employees.add(employee);

        System.out.println("Employees :  " + employees);


        // System.out.println(employee.empId);
        // System.out.println(employee.name);
        // System.out.println(employee.salary);

    }

}
