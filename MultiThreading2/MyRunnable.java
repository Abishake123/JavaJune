package MultiThreading2;

public class MyRunnable implements Runnable {

    private String threadName;
    

    public MyRunnable(String threadName) {
        
        this.threadName = threadName;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {

            try {
                Thread.sleep(1000);
                System.out.println(threadName + " --> " +  i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

}
