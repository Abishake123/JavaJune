package KitchenThreads;

import java.util.LinkedHashMap;
import java.util.Map;

/** The restaurant menu: dish name -> cooking time in seconds. */
public class Menu {

    private static final Map<String, Integer> COOKING_TIME = new LinkedHashMap<>();

    static {
        COOKING_TIME.put("Idli", 2);
        COOKING_TIME.put("Dosa", 3);
        COOKING_TIME.put("Vada", 1);
        COOKING_TIME.put("Pongal", 3);
        COOKING_TIME.put("Parotta", 4);
        COOKING_TIME.put("Biryani", 10);
    }

    public static boolean has(String dish) {
        return COOKING_TIME.containsKey(dish);
    }

    public static int cookingTime(String dish) {
        return COOKING_TIME.get(dish);
    }

    public static Map<String, Integer> all() {
        return COOKING_TIME;
    }
}
