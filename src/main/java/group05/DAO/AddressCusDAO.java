package group05.DAO;

import java.sql.SQLException;

import group05.Model.AddressCus;

public interface AddressCusDAO {
    AddressCus getAddressCus(String customer_id) throws SQLException;
    AddressCus setAddressCus(String addressCustomer) throws SQLException;
}