package InterfaceConstructorUse;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class App {


    public static void main(String[] args) {

        Animal animal = new Cat();

        animal.eat();

        Animal animal2 = new Dog();

        animal2.eat();


        List<Integer> numbers = new LinkedList<>();

        LinkedList<Integer> numbrs2 = new LinkedList<>();

        ArrayList<Integer> numbers1 = new ArrayList<>();
        
    }
    
}
