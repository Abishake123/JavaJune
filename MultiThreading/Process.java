package MultiThreading;

public class Process implements Runnable{


    Integer startI;
    Integer endI;

    public Process(Integer startI, Integer endI) {
        this.startI = startI;
        this.endI = endI;
    }

    @Override
    public void run() {
       
        for (int i = startI; i < endI; i++) {
            System.out.println(i);
        }



    }


    
    
}
