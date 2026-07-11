package EmployeeEncapsulation;

public class Employee {


    public String name;

    private Long salary;

    public String role;


    public void setSalary(Long salary, String pwd){
        if(pwd.equals("HR")){
            this.salary = salary;
        }
    }

    public Long getSalary(String pwd){
        if(pwd.equals(this.name)){
            return salary;
        }
        return null;
    }

    @Override
    public String toString() {
        return "Employee [name=" + name + ", salary=" + salary + ", role=" + role + "]";
    }
    
}
