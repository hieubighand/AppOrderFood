package group05.Model;

public class OrderDetail {
    private int orders_id;
    private int food_id;
    private int orders_amount;

    public int getOrders_amount() {
        return this.orders_amount;
    }

    public void setOrders_amount(int orders_amount) {
        this.orders_amount = orders_amount;
    }

    public int getOrders_id() {
        return this.orders_id;
    }

    public void setOrders_id(int orders_id) {
        this.orders_id = orders_id;
    }

    public int getFood_id() {
        return this.food_id;
    }

    public void setFood_id(int food_id) {
        this.food_id = food_id;
    }

}