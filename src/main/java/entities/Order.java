package main.java.entities;

import java.time.LocalDateTime;
import java.util.List;

// 订单类
public class Order {
    private int orderID;
    private int studentID;
    private int merchantID;
    private Dish dish;
    private int quantity;
    private LocalDateTime orderTime;
    private double totalPrice;
    private int status;                 // 订单状态 (0：待下单，1：下单成功，2：订单取消)

    public Order(int studentID, int merchantID, Dish dish, int quantity, LocalDateTime orderTime, double totalPrice, int status) {
        this.studentID = studentID;
        this.merchantID = merchantID;
        this.dish = dish;
        this.quantity = quantity;
        this.orderTime = orderTime;
        this.totalPrice = totalPrice;
        this.status = status;
    }

    public Order(int orderID, int studentID, int merchantID, Dish dish, int quantity, LocalDateTime orderTime, double totalPrice, int status) {
        this.orderID = orderID;
        this.studentID = studentID;
        this.merchantID = merchantID;
        this.dish = dish;
        this.quantity = quantity;
        this.orderTime = orderTime;
        this.totalPrice = totalPrice;
        this.status = status;
    }


    // Getters
    public int getOrderID() {
        return orderID;
    }
    public int getStudentID() {
        return studentID;
    }
    public int getMerchantID() {
        return merchantID;
    }
    public Dish getDishes() {
        return dish;
    }
    public int getQuantity() {
        return quantity;
    }
    public LocalDateTime getOrderTime() {
        return orderTime;
    }
    public double getTotalPrice() {
        return totalPrice;
    }
    public int getStatus() {
        return status;
    }

    // Setters
    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }
    public void setMerchantID(int merchantID) {
        this.merchantID = merchantID;
    }
    public void setDish(Dish dish) {
        this.dish = dish;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    public void setOrderTime(LocalDateTime orderTime) {
        this.orderTime = orderTime;
    }
    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }
    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Order{" +
                "订单号：" + orderID +
                ", 下单学生ID：" + studentID +
                ", 接单商家ID：" + merchantID +
                ", 下单时间：" + orderTime +
                ", 菜品：" + dish +
                ", 总金额：" + totalPrice +
                ", 订单状态：" + status +
                "}";
    }


}
