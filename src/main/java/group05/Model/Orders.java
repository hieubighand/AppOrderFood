package group05.Model;

import java.sql.Timestamp;

public class Orders {
    private int orders_id;
    private int customer_id;
    private Timestamp orders_date;

    public int getOrders_id() {
        return this.orders_id;
    }

    public void setOrders_id(int orders_id) {
        this.orders_id = orders_id;
    }

    public int getCustomer_id() {
        return this.customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    public Timestamp getOrders_date() {
        return this.orders_date;
    }

    public void setOrders_date(Timestamp orders_date) {
        this.orders_date = orders_date;
    }
}