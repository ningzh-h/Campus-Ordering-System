package codes.java.entities;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

// 订单类
public class Order {
    private static int nextId = 1;      // 用于生成下一个订单ID的静态变量

    private final int orderId;          // 订单ID
    private List<Integer> quantities = new ArrayList<Integer>();
    private int studentId;              // 下单学生ID
    private int merchantId;             // 接单商家ID
    private LocalDateTime orderTime;    // 下单时间
    private List<Dish> dishes;          // 菜品列表
    private double totalPrice;          // 订单总金额
    private int status;                 // 订单状态 (0：待下单，1：下单成功，2：订单取消)
    private String address;             // 送餐地址


    // 构造函数
    public Order(int studentId, int merchantId, LocalDateTime orderTime, List<Dish> dishes, List<Integer> quantities, double totalPrice, int status, String address) {
        this.orderId = nextId++;
        this.studentId = studentId;
        this.merchantId = merchantId;
        this.orderTime = orderTime;
        this.dishes = dishes;
        this.quantities = quantities;
        this.totalPrice = totalPrice;
        this.status = status;
        this.address = address;
    }

    // Getters
    public int getOrderId() {
        return orderId;
    }
    public int getStudentId() {
        return studentId;
    }
    public int getMerchantId() {
        return merchantId;
    }
    public LocalDateTime getOrderTime() {
        return orderTime;
    }
    public List<Dish> getDishes() {
        return dishes;
    }
    public double getTotalPrice() {
        return totalPrice;
    }
    public int getStatus() {
        return status;
    }
    public String getAddress() {
        return address;
    }

    // Setters
    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }
    public void setMerchantId(int merchantId) {
        this.merchantId = merchantId;
    }
    public void setOrderTime(LocalDateTime orderTime) {
        this.orderTime = orderTime;
    }
    public void setDishes(List<Dish> dishes) {
        this.dishes = dishes;
    }
    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }
    public void setStatus(int status) {
        this.status = status;
    }
    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Order{" +
                "订单号：" + orderId +
                ", 下单学生ID：" + studentId +
                ", 接单商家ID：" + merchantId +
                ", 下单时间：" + orderTime +
                ", 菜品：" + dishes +
                ", 总金额：" + totalPrice +
                ", 订单状态：" + status +
                ", 送达地址：" + address +
                '}';
    }


}
