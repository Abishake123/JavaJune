package MultiThreading;

public class App {

    public static void main(String[] args) {

        Thread t1 = new Thread(new Process(0, 500000));
        Thread t2 = new Thread(new Process(500001, 1000000));

        long startTime = System.currentTimeMillis();

        t1.start();
        t2.start();



        long endTime = System.currentTimeMillis();

        long totalTime = endTime - startTime;

        System.out.println("Total time: " + totalTime + " ms");
        System.out.println("Total time: " + (totalTime / 1000.0) + " s");

    }

}
