package group05.Model;

import java.time.LocalDate;

public class Customer {
    private int customer_id;
    private String customer_userName;
    private String customer_password;
    private String customer_name;
    private String customer_email;
    private String customer_phone;
    private LocalDate customer_date;

    public int getCustomer_id() {
        return this.customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    public String getCustomer_userName() {
        return this.customer_userName;
    }

    public void setCustomer_userName(String customer_userName) {
        this.customer_userName = customer_userName;
    }

    public String getCustomer_password() {
        return this.customer_password;
    }

    public void setCustomer_password(String customer_password) {
        this.customer_password = customer_password;
    }

    public String getCustomer_name() {
        return this.customer_name;
    }

    public void setCustomer_name(String customer_name) {
        this.customer_name = customer_name;
    }

    public String getCustomer_email() {
        return this.customer_email;
    }

    public void setCustomer_email(String customer_email) {
        this.customer_email = customer_email;
    }

    public String getCustomer_phone() {
        return this.customer_phone;
    }

    public void setCustomer_phone(String customer_phone) {
        this.customer_phone = customer_phone;
    }

    public LocalDate getCustomer_date() {
        return this.customer_date;
    }

    public void setCustomer_date(LocalDate customer_date) {
        this.customer_date = customer_date;
    }

}