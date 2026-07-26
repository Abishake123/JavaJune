package JavaOOPs.QuickRefresh.USD;

import java.util.ArrayList;

public class User {


    public Integer id;

    public String name;

    public ArrayList<Address> address; // {city : "" , pinCode : 0}

    @Override
    public String toString() {
        return "User [id=" + id + ", name=" + name + ", address=" + address + "]";
    }

    
    
    
}
