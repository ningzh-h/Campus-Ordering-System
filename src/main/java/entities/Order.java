package main.java.entities;

import main.java.entities.users.Merchant;
import main.java.entities.users.Student;

import java.time.LocalDateTime;

import static java.time.format.DateTimeFormatter.ofPattern;

// 订单类
public class Order {
    private int orderID;
    private Student student;
    private Merchant merchant;
    private Dish dish;
    private int quantity;
    private LocalDateTime orderTime;
    private double totalPrice;
    private int status;                 // 订单状态 (0：待下单，1：下单成功，2：订单取消)

    public Order(Student student, Merchant merchant, Dish dish, int quantity, LocalDateTime orderTime, double totalPrice, int status) {
        this.student = student;
        this.merchant = merchant;
        this.dish = dish;
        this.quantity = quantity;
        this.orderTime = orderTime;
        this.totalPrice = totalPrice;
        this.status = status;
    }

    public Order(int orderID, Student student, Merchant merchant, Dish dish, int quantity, LocalDateTime orderTime, double totalPrice, int status) {
        this.orderID = orderID;
        this.student = student;
        this.merchant = merchant;
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
    public Student getStudent() {
        return student;
    }
    public Merchant getMerchant() {
        return merchant;
    }
    public Dish getDish() {
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
    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }
    public void setStudent(Student student) {
        this.student = student;
    }
    public void setMerchant(Merchant merchant) {
        this.merchant = merchant;
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
        String statusStr;
        if (status == 1) {
            statusStr = "下单成功";
        } else {
            statusStr = "订单取消";
        }

        return  "订单号：" + orderID +
                "\n下单学生ID：" + student.getUserID() +
                "\n接单商家：" + merchant.getUsername() +
                "\n餐品：" + dish.getDishName() +
                "\n数量：" + quantity +
                "\n总金额：" + totalPrice +
                "\n顾客手机：" + student.getPhone() +
                "\n下单时间：" + orderTime.format(ofPattern("yyyy-MM-dd HH:mm:ss")) +
                "\n送达地址：" + student.getAddress() +
                "\n订单状态：" + statusStr;
    }
}
