package group05.Model;

public class Restaurant {
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
}