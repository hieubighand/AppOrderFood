package group05.BL;

import java.sql.SQLException;
import java.util.ArrayList;

import group05.DAL.FoodDAL;
import group05.Model.Food;

public class FoodBL {
    FoodDAL foodDAL = new FoodDAL();

    public ArrayList<Food> gList(int Id) {
       return foodDAL.gList(Id);
    }

    public Food getFood(int Id) throws SQLException {
        return foodDAL.getFood(Id);
    }

}