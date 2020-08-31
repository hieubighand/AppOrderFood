package group05.DAL;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import group05.DAO.FoodDAO;
import group05.Model.Food;

public class FoodDAL implements FoodDAO {
    private String query;
    private ResultSet rs;

    @Override
    public ArrayList<Food> gList(int Id) {
        ArrayList<Food> listFoods = new ArrayList<>();
        query = "SELECT * FROM restaurant AS r INNER JOIN foodRestaurantDetail AS detail ON detail.restaurant_id = r.restaurant_id INNER JOIN food AS f ON detail.food_id = f.food_id WHERE r.restaurant_id = " + Id + ";";

        try {
            DBHelper.getConnection();
            rs = DBHelper.executeQuery(query);
            while (rs.next()) {
                Food food = getFood(rs);
                listFoods.add(food);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if(listFoods.size() > 0){
            return listFoods;
        }
        return null;
    }

    @Override
    public Food getFood(int Id) throws SQLException {
        Food food = null;
        query = "SELECT * FROM restaurant AS r INNER JOIN foodRestaurantDetail AS detail ON detail.restaurant_id = r.restaurant_id INNER JOIN food AS f ON detail.food_id = f.food_id WHERE f.food_id = " + Id + ";";

        DBHelper.getConnection();
        rs = DBHelper.executeQuery(query);

        while (rs.next()) {
            food = getFood(rs);
        }
        DBHelper.closeConnection();
        return food;
    }

    private Food getFood(ResultSet rs) throws SQLException {
        Food food = new Food();
        food.setFood_id(rs.getInt("food_id"));
        food.setFood_name(rs.getString("food_name"));
        food.setFood_price(rs.getInt("food_price"));
        food.setRestaurant_id(rs.getInt("restaurant_id"));
        food.setRestaurant_name(rs.getString("restaurant_name"));
        food.setRestaurant_address(rs.getString("restaurant_address"));
        food.setRestaurant_timeOC(rs.getString("restaurant_timeCO"));

        return food;
    }
}  