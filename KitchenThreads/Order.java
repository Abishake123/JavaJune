package KitchenThreads;

/** One order = one dish to cook. */
public class Order {

    private final int orderId;
    private final String dish;

    public Order(int orderId, String dish) {
        this.orderId = orderId;
        this.dish = dish;
    }

    public int getOrderId() {
        return orderId;
    }

    public String getDish() {
        return dish;
    }

    public int getCookingTime() {
        return Menu.cookingTime(dish);
    }

    @Override
    public String toString() {
        return "#" + orderId + " " + dish + " (" + getCookingTime() + "s)";
    }
}
