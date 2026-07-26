package JavaOOPs.QuickRefresh.USD;

public class Address {


    public Long pinCode;

    public String city;

    Address(){
        
    }

    public Address(Long pinCode, String city) {
        this.pinCode = pinCode;
        this.city = city;
    }



    @Override
    public String toString() {
        return "Address [pinCode=" + pinCode + ", city=" + city + "]";
    }

    

    
}
