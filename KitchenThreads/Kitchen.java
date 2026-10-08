package KitchenThreads;

import java.util.List;

/** Runs a batch of orders with a given number of chefs and prints a summary. */
public class Kitchen {

    private static long startTime;

    /** Prints a message with the time since the kitchen opened, e.g. "[ 3.0s] Chef-1 ...". */
    public static synchronized void log(String message) {
        double elapsed = (System.currentTimeMillis() - startTime) / 1000.0;
        System.out.printf("[%5.1fs] %s%n", elapsed, message);
    }

    public static void run(List<String> dishes, int numberOfChefs) throws InterruptedException {
        OrderQueue queue = new OrderQueue(dishes);
        int totalOrders = queue.size();

        System.out.println("\n==============================================");
        System.out.println(" " + totalOrders + " orders, " + numberOfChefs + " chef(s)");
        System.out.println("==============================================");

        // 1. Create one Chef (Runnable) + one Thread per chef
        Chef[] chefs = new Chef[numberOfChefs];
        Thread[] threads = new Thread[numberOfChefs];
        for (int i = 0; i < numberOfChefs; i++) {
            chefs[i] = new Chef("Chef-" + (i + 1), queue);
            threads[i] = new Thread(chefs[i]);
        }

        // 2. Start all threads -> they now cook at the same time
        startTime = System.currentTimeMillis();
        for (Thread t : threads) {
            t.start();
        }

        // 3. join() = main thread waits here until every chef is finished
        for (Thread t : threads) {
            t.join();
        }

        double totalSeconds = (System.currentTimeMillis() - startTime) / 1000.0;

        System.out.println("----------------------------------------------");
        for (Chef chef : chefs) {
            System.out.printf("%-8s cooked %d dish(es), busy for %ds%n",
                    chef.getName(), chef.getDishesCooked(), chef.getSecondsWorked());
        }
        System.out.printf("Orders completed: %d/%d%n", queue.getCompletedCount(), totalOrders);
        System.out.printf("Total time with %d chef(s): %.1fs%n", numberOfChefs, totalSeconds);
    }
}
