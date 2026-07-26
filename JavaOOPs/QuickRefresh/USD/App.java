package JavaOOPs.QuickRefresh.USD;

import java.util.ArrayList;

public class App {


    public static void main(String[] args) {
        

        User user = new User();

        user.name = "Jhon";
        user.id = 1;

        ArrayList<Address> addresses = new ArrayList<>();

        Address address = new Address(6000l,"Chennai");

        // address.city = "Chennai";
        // address.pinCode = 600054l;

        addresses.add(address);

        address = new Address();

        address.city = "Mumbai";
        address.pinCode = 450000l;

        addresses.add(address);

        user.address = addresses;

        System.out.println("User : " + user);
    }
    
}
