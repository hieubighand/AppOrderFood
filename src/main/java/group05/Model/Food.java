package group05.Model;

public class Food {
    private int food_id;
    private String food_name;
    
    private int food_price;

    private int restaurant_id;
    private String restaurant_name;
    private String restaurant_address;
    private String restaurant_timeOC;
    private double restaurant_rate;

    public int getRestaurant_id() {
        return this.restaurant_id;
    }

    public void setRestaurant_id(int restaurant_id) {
        this.restaurant_id = restaurant_id;
    }

    public String getRestaurant_name() {
        return this.restaurant_name;
    }

    public void setRestaurant_name(String restaurant_name) {
        this.restaurant_name = restaurant_name;
    }

    public String getRestaurant_address() {
        return this.restaurant_address;
    }

    public void setRestaurant_address(String restaurant_address) {
        this.restaurant_address = restaurant_address;
    }

    public String getRestaurant_timeOC() {
        return this.restaurant_timeOC;
    }

    public void setRestaurant_timeOC(String restaurant_timeOC) {
        this.restaurant_timeOC = restaurant_timeOC;
    }

    public double getRestaurant_rate() {
        return this.restaurant_rate;
    }

    public void setRestaurant_rate(double restaurant_rate) {
        this.restaurant_rate = restaurant_rate;
    }

    public int getFood_price() {
        return this.food_price;
    }

    public void setFood_price(int food_price) {
        this.food_price = food_price;
    }

    public int getFood_id() {
        return this.food_id;
    }

    public void setFood_id(int food_id) {
        this.food_id = food_id;
    }

    public String getFood_name() {
        return this.food_name;
    }

    public void setFood_name(String food_name) {
        this.food_name = food_name;
    }
}