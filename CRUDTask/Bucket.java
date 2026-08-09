package CRUDTask;

import java.util.ArrayList;
import java.util.Scanner;

public class Bucket {



    ArrayList<Integer> numbersBucket = new ArrayList<>();

    Scanner scan = new Scanner(System.in);

    public void create(){

        System.out.println("Enter the Number to be Added : ");

        int element = scan.nextInt();

        numbersBucket.add(element);

        System.out.println("Added a New Element : " + element);
    }

    public void list(){

        System.out.println("List All Records : " + numbersBucket);
        
    }
    
}
