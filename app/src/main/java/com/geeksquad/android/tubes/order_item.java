package com.geeksquad.android.tubes;

/**
 * Created by ASUS on 25/10/2017.
 */

public class order_item {

    public order_item(String no_order, String date_order){
        this.setNo_order(no_order);
        this.setDate_order(date_order);

    }
    private String no_order,date_order;

    public String getNo_order() {
        return no_order;
    }

    public void setNo_order(String no_order) {
        this.no_order = no_order;
    }

    public String getDate_order() {
        return date_order;
    }

    public void setDate_order(String date_order) {
        this.date_order = date_order;
    }
}
