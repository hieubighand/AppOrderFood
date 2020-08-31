package group05.BL;

import java.sql.SQLException;

import group05.DAL.CustomerDAL;
import group05.Model.Customer;

public class CustomerBL {
    CustomerDAL customerDAL = new CustomerDAL();
    Customer cus;

    public boolean login(String userName, String password) throws SQLException {
        cus = customerDAL.getCustomer(userName);
        if (cus.getCustomer_password().equals(password)) {
            return true;
        }
        else {
            return false;
        }
    }

    public Customer getCustomer() {
        return cus;
    }
}