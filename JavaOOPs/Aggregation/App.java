package Aggregation;

public class App {

    public static void main(String[] args) {
        

        Employee employee = new Employee();


        employee.name = "jhon";
        employee.isMarried = false;

        Address address = new Address();

        address.city = "Chennai";
        address.pincode = 60000;
        address.streetName = "Street Name";

        employee.address = address;

        employee.id = 45;


        System.out.println(employee);
    }
    
}
