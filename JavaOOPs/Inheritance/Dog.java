package Inheritance;

public class Dog extends Animal{

    Dog(){
        System.out.println("From Dog Class Constructor");
    }

    public void eat(){
        System.out.println("Eats Bone & Meat");
        super.eat();
    }

    public void hunt(){
        System.out.println("Huts cat..");
    }
    
}
