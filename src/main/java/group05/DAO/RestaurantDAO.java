package group05.DAO;

import java.sql.SQLException;
import java.util.ArrayList;

import group05.Model.Restaurant;

public interface RestaurantDAO {
    ArrayList<Restaurant> gList();
    Restaurant getRestaurant(int Id) throws SQLException;
}