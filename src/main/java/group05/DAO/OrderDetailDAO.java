package group05.DAO;

import java.sql.SQLException;
import java.util.ArrayList;

import group05.Model.OrderDetail;

public interface OrderDetailDAO {
    Boolean addOrderDetail(OrderDetail orderDetail) throws SQLException;
    ArrayList<OrderDetail> getOrderDetail(int OrderID) throws SQLException;
}