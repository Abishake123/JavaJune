package ExceptionHandling;

import java.util.InputMismatchException;
import java.util.Scanner;

public class App {


    public static void main(String[] args) {
        int n = 20;

        Scanner scan = new Scanner(System.in);

        System.out.print("Enter the Divident : ");
       
        int result = 0;

        try {
            int x = scan.nextInt();

            if(x < 5){
                throw new LimitToFiveException();
            }
            result = n/x;
        }catch(InputMismatchException e){
            System.out.println("Pls Provide only Integers");
        }catch(ArithmeticException a){
            System.out.println("It Provide Infinite...");
        }catch(LimitToFiveException l){
           System.out.println("Limit to 5 , Enter greater thna 5");
        }catch(Exception e){
            System.out.println("Something Went Wrong");
        }finally{
            System.out.println("Finally Auto Saving and Closing the Software...");
        }

        System.out.println("Result : " + result);

        System.out.println("End of Software...");
    }
    
}
