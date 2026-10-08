package KitchenThreads;

import java.util.LinkedList;
import java.util.List;

/**
 * The order board that ALL chefs share.
 *
 * Every chef thread keeps asking "give me the next order". Because many threads
 * touch the same list at the same time, the methods are synchronized:
 * only ONE chef can be inside them at a time, so two chefs never grab the same order
 * and no order is skipped.
 */
public class OrderQueue {

    private final LinkedList<Order> pending = new LinkedList<>();
    private int completedCount = 0;

    public OrderQueue(List<String> dishes) {
        int id = 1;
        for (String dish : dishes) {
            if (!Menu.has(dish)) {
                System.out.println("Skipping unknown dish: " + dish);
                continue;
            }
            pending.add(new Order(id++, dish));
        }
    }

    /** Returns the next order, or null when there is nothing left to cook. */
    public synchronized Order takeNext() {
        if (pending.isEmpty()) {
            return null;
        }
        return pending.removeFirst();
    }

    /** completedCount++ is read-modify-write, so it must be synchronized too. */
    public synchronized void markDone() {
        completedCount++;
    }

    public synchronized int getCompletedCount() {
        return completedCount;
    }

    public synchronized int size() {
        return pending.size();
    }
}
