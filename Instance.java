public class Instance {

    int x = 2;
    static String s = "Hello";


    public static void main(String[] args) {

        Instance ins1 = new Instance(); // ram 1 mem
        ins1.x = 3;
        ins1.s = "Hi";

        Instance ins2 = new Instance(); // ram 2 mem
        ins2.x = 44;

         System.out.println("Ins 1 Int : " + ins1.x);
         System.out.println("Ins 1 Str : " + ins1.s);
         System.out.println("Ins 2 Int : " + ins2.x);
         System.out.println("Ins 2 Str : " + ins2.s);
        
    }   
    
    

    static void learnJava(){
        System.out.println("Learning Java");
    }
    

    void hobbies(){
        System.out.println("...");
    }
}
