package group05.BL;

import java.sql.SQLException;
import java.util.ArrayList;

import group05.DAL.OrdersDetailDAL;
import group05.Model.OrderDetail;

public class OrderDetailBL {
    OrdersDetailDAL detailDAL = new OrdersDetailDAL();

    public Boolean addOrderDetail(OrderDetail orderDetail) throws SQLException {
        return detailDAL.addOrderDetail(orderDetail);
    }

    public ArrayList<OrderDetail> getOrderDetail(int OrderID) throws SQLException {
        return detailDAL.getOrderDetail(OrderID);
    }

}