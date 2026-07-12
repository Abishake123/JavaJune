package Constructors.ConstructorTemplate;

public class User {


    Integer id;

    String name;

    Integer age;

    User(){
     System.out.println("Constructir is working ...");   

     this.age = 29;
     this.name = "Alex";
     this.id = 2;
    }

    User(int x){

    }

    User(int y,int x){

    }

    
}
