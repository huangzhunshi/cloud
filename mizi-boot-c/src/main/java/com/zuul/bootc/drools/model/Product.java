package com.zuul.bootc.drools.model;

/**
 * 产品类
 * Created by zhuzs on 2017/7/4.
 */
public class Product {

    public Product(String type, int discount) {
        this.type = type;
        this.discount = discount;
    }

    public Product(){

    }

    /**
     * 钻石
     */
    public static final String DIAMOND = "0";

    /**
     * 黄金
     */
    public static final String GOLD = "1";

    private String type;

    private int discount;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }
}
