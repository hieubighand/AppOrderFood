package group05.DAO;

import java.sql.SQLException;

import group05.Model.Orders;

public interface OrdersDAO {
    Boolean addOrder(Orders orders) throws SQLException;
    Orders getOrder(int CustomerID) throws SQLException;
}