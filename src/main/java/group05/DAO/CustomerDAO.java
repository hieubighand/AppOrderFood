package group05.DAO;

import java.sql.SQLException;

import group05.Model.Customer;

public interface CustomerDAO {
    Customer getCustomer(String userName) throws SQLException;
    Customer getByID(int Id) throws SQLException;
}