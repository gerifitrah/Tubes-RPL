package com.geeksquad.android.tubes.entity;

/**
 * Created by ASUS on 25/10/2017.
 */

public class Order {

    private String mOrderNumber, mOrderDate;

    public static String USERNAME = "admin" ;
    public static String PASSWORD = "jasuke" ;


    public Order(String orderNumber, String orderDate) {
        this.setmOrderNumber(orderNumber);
        this.setDate_order(orderDate);

    }

    public String getmOrderNumber() {
        return mOrderNumber;
    }

    public void setmOrderNumber(String mOrderNumber) {
        this.mOrderNumber = mOrderNumber;
    }

    public String getDate_order() {
        return mOrderDate;
    }

    public void setDate_order(String date_order) {
        this.mOrderDate = date_order;
    }
}
