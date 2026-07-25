package Interface;

public class Suzuki implements Bike {

    public void tyreSize() {
        System.out.println("17/170");
    }

    public void fuelType() {
        System.out.println("Petrol");
    }

    public void displacement() {
        System.out.println(230);
    }

    @Override
    public void seaterCount() {
        System.out.println(2);
    }

}
