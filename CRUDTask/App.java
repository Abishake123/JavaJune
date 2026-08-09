package CRUDTask;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        Integer option = 0;

        Bucket bucket = new Bucket();

        while (option != 5) {

            System.out.println("Choose The Option :  ");
            System.out.println("1: For Create new Element ");
            System.out.println("2: For List all Records ");
            System.out.println("5: For Exit");
            System.out.println("Enter your choice : ");
            option = scan.nextInt();


            if(option == 1){
                bucket.create();
            }else if (option == 2) {
                bucket.list();
            }



        }

    }



}
