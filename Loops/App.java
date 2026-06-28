package Loops;

import java.util.Arrays;
import java.util.List;

public class App {

    public static void main(String[] args) {
        // constraint -> 21 age above to get in..
        // for 100 customers ...

        int age = 26;

        List<Integer> ages = Arrays.asList(23, 34, 5, 67, 33, 13, 19, 20);

        System.out.println("Size of List : " + ages.size());

        // for(intialize ; condition ; increment or decrement) {}

        for (int i = 0; i < ages.size(); i++) {
            System.out.println("Loop Count : " + (i + 1));
            System.out.println(" Age : " + ages.get(i));
            if (ages.get(i) > 21) {
                System.out.println("Door Opens ...");
            } else {
                System.out.println("Door Closed ... ");
            }
        }

        int i = 0;
        while (i < ages.size()) { 
            

            i++;
        }

    }

}
