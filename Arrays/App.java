package Arrays;

import java.util.List;

public class App {

    //int x = 2;

    // List numbers = [1,2,3,4,5];


    public static void main(String[] args) {

        int numbers[] = {1,2,3,4,5,3,4};
        
        System.out.println(numbers[6]);

        for(int i = 0; i < numbers.length; i++){
           
            // <condition> ? true : false
            
            System.out.print(numbers[i] + ((i == 0 || i == 6) ? " " : ", "));
            
        }
        
    }
    
}
