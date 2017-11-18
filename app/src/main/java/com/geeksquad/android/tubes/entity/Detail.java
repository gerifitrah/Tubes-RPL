package com.geeksquad.android.tubes.entity;

/**
 * Created by GOODWARE1 on 11/18/2017.
 */

public class Detail {
    private String produk;
    private int qty;

    public Detail(String produk, int qty) {
        this.produk = produk;
        this.qty = qty;
    }

    public String getProduk() {
        return produk;
    }

    public int getQty() {
        return qty;
    }
}
