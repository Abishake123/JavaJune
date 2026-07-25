package Aggregation;

public class Employee {

    public Integer id;

    public String name;

    public Address address; 

    public Boolean isMarried;

    @Override
    public String toString() {
        return "Employee [id=" + id + ", name=" + name + ", address=" + address + ", isMarried=" + isMarried + "]";
    }

    
    
}
