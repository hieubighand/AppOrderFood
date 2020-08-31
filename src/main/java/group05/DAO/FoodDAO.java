package group05.DAO;

import java.sql.SQLException;
import java.util.ArrayList;

import group05.Model.Food;

public interface FoodDAO {
    ArrayList<Food> gList(int Id);
    Food getFood(int Id) throws SQLException;
}