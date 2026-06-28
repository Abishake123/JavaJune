package Loops;

public class ContinueBreak {

    public static void main(String[] args) {
        
        // Conitnue & break
        // labled

        // for(int i = 0; i < 10; i++){
        //     if(i == 5) continue;
        //     System.out.println("I : " + i);
        // }

        loop1:for(int i = 0; i < 2; i++){
            loop2:for(int j = 0; j < 2; j++){
               System.out.println("I :" + i + " J : " + j);
               if(j == 1) break loop1;
            }
        }
    }
    
}
