package group05.BL;

import java.sql.SQLException;
import java.util.ArrayList;

import group05.DAL.RestaurantDAL;
import group05.Model.Restaurant;

public class RestaurantBL {
    RestaurantDAL restaurantDAL = new RestaurantDAL();

    public ArrayList<Restaurant> gList() {
        return restaurantDAL.gList();
    }

    public Restaurant getRestaurant(int Id) throws SQLException {
        return restaurantDAL.getRestaurant(Id);
    }
}