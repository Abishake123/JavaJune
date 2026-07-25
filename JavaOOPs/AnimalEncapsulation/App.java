package AnimalEncapsulation;
import java.util.ArrayList;

public class App {
    
    public static void main(String[] args) {

        ArrayList<Animal> animals = new ArrayList<>();
       Animal animal = new Animal();

       animal.name = "Beaver";
       animal.isCarnivore = true;
       animal.lifeSpan = 15;
       animal.updateIsEddible(true,"ANI");

       animals.add(animal);

       animal = new Animal();

       animal.name = "Dog";
       animal.isCarnivore = true;
       animal.lifeSpan = 20;
       animal.returnIsEddible();

       animals.add(animal);


       System.out.println("Animals : " + animals);
    }
}