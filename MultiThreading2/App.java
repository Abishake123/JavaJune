package MultiThreading2;

public class App {

    public static void main(String[] args) {

        System.out.println("thread Process Starts : ");

        Thread thread1 = new Thread(new MyRunnable("Thread1"));
        Thread thread2 = new Thread(new MyRunnable("Thread2"));

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();

        } catch (InterruptedException e) {

            e.printStackTrace();
        }

        System.out.println("thread Process Ends : ");

    }

}
