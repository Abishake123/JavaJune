package Occurences;

import java.util.ArrayList;

public class App {


    public static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList<>();
        numbers.add(2);
        numbers.add(2);
        numbers.add(2);
        numbers.add(4);
        numbers.add(4);
        numbers.add(5);

        System.out.println("Numbers : " + numbers);

        int coutner2 = 0;
        int coutner4 = 0;

        for(int i = 0; i < numbers.size();i++){
            if(numbers.get(i) == 2){
                coutner2++;
            }

            if(numbers.get(i) == 4){
                coutner4++;
            }
        }

        System.out.println("Coutern : " + coutner2);
        System.out.println("Coutern : " + coutner4);
    }
    
}
