package Constructors.ConstructorUserSet;

public class App {


    public static void main(String[] args) {
        
       Student stud;

       stud = new Student("Alex", 102, true);
       stud = new Student("Jhon", 101, true);
       stud = new Student("Clark", 103);

        System.out.println("Student : " + stud);

    }
    
}
