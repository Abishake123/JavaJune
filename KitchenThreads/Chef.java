package KitchenThreads;

/**
 * A chef is a Runnable: each chef runs on its own Thread.
 * Loop: take an order from the shared queue -> cook it (sleep) -> repeat until the queue is empty.
 */
public class Chef implements Runnable {

    private final String name;
    private final OrderQueue queue;
    private int dishesCooked = 0;
    private int secondsWorked = 0;

    public Chef(String name, OrderQueue queue) {
        this.name = name;
        this.queue = queue;
    }

    @Override
    public void run() {
        Order order;
        while ((order = queue.takeNext()) != null) {
            Kitchen.log(name + " started  " + order);
            try {
                // Cooking = the thread sleeping for the dish's cooking time.
                Thread.sleep(order.getCookingTime() * 1000L);
            } catch (InterruptedException e) {
                Kitchen.log(name + " was interrupted!");
                return;
            }
            queue.markDone();
            dishesCooked++;
            secondsWorked += order.getCookingTime();
            Kitchen.log(name + " finished " + order);
        }
        Kitchen.log(name + " is free (no more orders)");
    }

    public String getName() {
        return name;
    }

    public int getDishesCooked() {
        return dishesCooked;
    }

    public int getSecondsWorked() {
        return secondsWorked;
    }
}
