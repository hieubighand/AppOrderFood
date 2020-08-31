package group05.DAL;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import group05.DAO.RestaurantDAO;
import group05.Model.Restaurant;

public class RestaurantDAL implements RestaurantDAO {
    private String query;
    private ResultSet rs;

    @Override
    public ArrayList<Restaurant> gList() {
        ArrayList<Restaurant> listRes = new ArrayList<>();
        query = "SELECT * FROM restaurant;";

        try {
            DBHelper.getConnection();
            rs = DBHelper.executeQuery(query);
            while (rs.next()) {
                Restaurant restaurant = getRestaurant(rs);
                listRes.add(restaurant);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listRes;
    }

    @Override
    public Restaurant getRestaurant(int Id) throws SQLException {
        Restaurant restaurant = null;
        query = "SELECT * FROM restaurant WHERE ID = " + Id + ";";
        DBHelper.getConnection();
        rs = DBHelper.executeQuery(query);

        while (rs.next()) {
            restaurant = getRestaurant(rs);
        }
        DBHelper.closeConnection();
        return restaurant;
    }

    private Restaurant getRestaurant(ResultSet rs) throws SQLException {
        Restaurant restaurant = new Restaurant();
        restaurant.setRestaurant_id(rs.getInt("restaurant_id"));
        restaurant.setRestaurant_name(rs.getString("restaurant_name"));
        restaurant.setRestaurant_address(rs.getString("restaurant_address"));
        restaurant.setRestaurant_timeOC(rs.getString("restaurant_timeCO"));
        return restaurant;
    }
}