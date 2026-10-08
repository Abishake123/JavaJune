package KitchenThreads;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * Restaurant kitchen simulation.
 *
 *   java KitchenThreads.App        -> runs with 1 chef, then with 3 chefs (to compare)
 *   java KitchenThreads.App 2      -> runs with 2 chefs only
 */
public class App {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("MENU");
        for (Map.Entry<String, Integer> item : Menu.all().entrySet()) {
            System.out.printf("  %-8s %2ds%n", item.getKey(), item.getValue());
        }

        List<String> orders = Arrays.asList(
                "Idli", "Biryani", "Dosa", "Vada", "Pongal",
                "Dosa", "Parotta", "Idli", "Biryani", "Vada");

        int totalCookingTime = 0;
        for (String dish : orders) {
            totalCookingTime += Menu.cookingTime(dish);
        }
        System.out.println("\nOrders: " + orders);
        System.out.println("Sum of all cooking times: " + totalCookingTime + "s");

        if (args.length > 0) {
            Kitchen.run(orders, Integer.parseInt(args[0]));
        } else {
            Kitchen.run(orders, 1); // one chef -> everything happens one after another
            Kitchen.run(orders, 3); // three chefs -> work is split between them
        }
    }
}
