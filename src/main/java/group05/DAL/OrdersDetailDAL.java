package group05.DAL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import group05.DAO.OrderDetailDAO;
import group05.Model.OrderDetail;

public class OrdersDetailDAL implements OrderDetailDAO{
    String query;

    @Override
    public Boolean addOrderDetail(OrderDetail orderDetail) throws SQLException {
        Connection con = DBHelper.getConnection();
        DBHelper.executeQuery("SET FOREIGN_KEY_CHECKS = 0;");
        query = "INSERT INTO ordersDetail(food_id, orders_id, orders_amount) values (?, ?, ?);";
        PreparedStatement preparedStatement = con.prepareStatement(query);
        preparedStatement.setInt(1, orderDetail.getFood_id());
        preparedStatement.setInt(2, orderDetail.getOrders_id());
        preparedStatement.setInt(3, orderDetail.getOrders_amount());
        Boolean b = preparedStatement.execute();
        DBHelper.executeQuery("SET FOREIGN_KEY_CHECKS = 1;");
        DBHelper.closeConnection();
        return b;
    }

    @Override 
    public ArrayList<OrderDetail> getOrderDetail(int OrderID) throws SQLException {
        query = "SELECT * FROM ordersDetail WHERE orders_id = " + OrderID + ";";
        DBHelper.getConnection ();
        ResultSet rs = DBHelper.executeQuery(query);
        ArrayList<OrderDetail> orderDetails = new ArrayList<OrderDetail>();
        while(rs.next()){
            OrderDetail orderDetail = getOrderDetail(rs);
            orderDetails.add(orderDetail);
        }
        DBHelper.closeConnection();
        return orderDetails;
    }

    private OrderDetail getOrderDetail(ResultSet rs) {
        try {
            OrderDetail orderDetail = new OrderDetail();
            orderDetail.setOrders_id(rs.getInt("orders_id"));
            orderDetail.setFood_id(rs.getInt("food_id"));
            orderDetail.setOrders_amount(rs.getInt("orders_amount"));
            return orderDetail;
        } catch(Exception e){
            return null;
        }
 
    }
}