package group05.DAL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import group05.DAO.OrdersDAO;
import group05.Model.Orders;

public class OrdersDAL implements OrdersDAO{
    String query;

    @Override
    public Boolean addOrder(Orders orders) throws SQLException {
        Connection connection = DBHelper.getConnection();
        DBHelper.executeQuery("SET FOREIGN_KEY_CHECKS = 0;");
        query = "INSERT INTO orders(customer_id) values (?);";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1, orders.getCustomer_id());
        Boolean b = preparedStatement.execute();
        DBHelper.executeQuery("SET FOREIGN_KEY_CHECKS = 1;");
        DBHelper.closeConnection();
        return b;
    }

    // public Orders getOrder() throws SQLException {
    //     query = "SELECT MAX(orders_id) as orders_id, customer_id, orders_date FROM orders;";
    //     DBHelper.getConnection();
    //     ResultSet rs = DBHelper.executeQuery(query);
    //     Orders orders = new Orders();
    //     while (rs.next()) {
    //         orders.setOrders_id(rs.getInt("orders_id"));
    //         orders.setCustomer_id(rs.getInt("customer_id"));
    //         // orders.setOrders_date(rs.getDate("orders_date"));
    //     }
    //     DBHelper.closeConnection();
    //     return orders;
    // }

    @Override
    public Orders getOrder(int CustomerID) throws SQLException {
        query = "SELECT * FROM orders WHERE customer_id = " + CustomerID + " ORDER BY orders_id DESC LIMIT 1;";
        DBHelper.getConnection();
        ResultSet rs = DBHelper.executeQuery(query);
        Orders order = new Orders();
        while (rs.next()) {
            order.setCustomer_id(rs.getInt("customer_id"));
            order.setOrders_id(rs.getInt("orders_id"));
            order.setOrders_date(rs.getTimestamp("orders_date"));
        }
        DBHelper.closeConnection();
        return order;
    }
}