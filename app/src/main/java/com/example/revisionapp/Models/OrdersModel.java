package com.example.revisionapp.Models;

public class OrdersModel {
    int orderImage;
    String soldItemName,orderNo,orderPrice2;

    public OrdersModel() {
        this.orderImage = orderImage;
        this.soldItemName = soldItemName;
        this.orderNo = orderNo;
        this.orderPrice2 = orderPrice2;
    }

    public int getOrderImage() {
        return orderImage;
    }

    public void setOrderImage(int orderImage) {
        this.orderImage = orderImage;
    }

    public String getSoldItemName() {
        return soldItemName;
    }

    public void setSoldItemName(String soldItemName) {
        this.soldItemName = soldItemName;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getOrderPrice2() {
        return orderPrice2;
    }

    public void setOrderPrice2(String orderPrice2) {
        this.orderPrice2 = orderPrice2;
    }
}
