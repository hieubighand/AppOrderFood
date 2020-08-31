package group05.DAL;

import java.sql.ResultSet;
import java.sql.SQLException;

import group05.DAO.CustomerDAO;
import group05.Model.Customer;

public class CustomerDAL implements CustomerDAO{
    String query;
    ResultSet rs;

    @Override
    public Customer getCustomer(String userName) throws SQLException{
        query = "SELECT * FROM customer WHERE customer_username = '" + userName + "';";
        DBHelper.getConnection();
        rs = DBHelper.executeQuery(query);
        Customer infCus = new Customer();

        while (rs.next()) {
            infCus.setCustomer_id(rs.getInt("customer_id"));
            infCus.setCustomer_email(rs.getString("customer_email"));
            infCus.setCustomer_userName(rs.getString("customer_username"));
            infCus.setCustomer_password(rs.getString("customer_password"));
            infCus.setCustomer_name(rs.getString("customer_name"));
            infCus.setCustomer_phone(rs.getString("customer_phone"));
        }
        return infCus;
    }

    @Override
    public Customer getByID(int Id) throws SQLException {
        query = "SELECT * FROM customer_id WHERE ID = " + Id + ";";
        DBHelper.getConnection();
        rs = DBHelper.executeQuery(query);
        Customer infCus = new Customer();
        while(rs.next()){
            infCus.setCustomer_id(rs.getInt("customer_id"));
            infCus.setCustomer_email(rs.getString("customer_email"));
            infCus.setCustomer_userName(rs.getString("customer_username"));
            infCus.setCustomer_password(rs.getString("customer_password"));
            infCus.setCustomer_name(rs.getString("customer_name"));
            infCus.setCustomer_phone(rs.getString("customer_phone"));
        }
        return infCus;
    }
}