package group05.BL;

import java.sql.SQLException;

import group05.DAL.OrdersDAL;
import group05.Model.Orders;

public class OrdersBL {
    OrdersDAL ordersDAL = new OrdersDAL();

    public Boolean addOrder(Orders orders) throws SQLException {
        return ordersDAL.addOrder(orders);
    }

    public Orders getOrders(int CustomerID) throws SQLException {
        return ordersDAL.getOrder(CustomerID);
    }
}