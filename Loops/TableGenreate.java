package Loops;

import java.util.Scanner;

public class TableGenreate {


    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        System.out.print("Enter a Multiplier :");
        int multiplier = scan.nextInt();

        System.out.println();

        // int multiplier = 5;
        
        for(int i = 0; i <= 12; i++){
            System.out.println(multiplier + " x " + i + " = " + (i * multiplier));
        }
    }
    
    
}
