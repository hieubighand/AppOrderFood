package group05.Model;

public class FoodDetail {
    private int food_id;
    private int restaurant_id;
    private int food_price;

    public int getFood_id() {
        return this.food_id;
    }

    public void setFood_id(int food_id) {
        this.food_id = food_id;
    }

    public int getRestaurant_id() {
        return this.restaurant_id;
    }

    public void setRestaurant_id(int restaurant_id) {
        this.restaurant_id = restaurant_id;
    }

    public int getFood_price() {
        return this.food_price;
    }

    public void setFood_price(int food_price) {
        this.food_price = food_price;
    }
}