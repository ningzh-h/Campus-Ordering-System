package codes.java.entities;

import codes.java.entities.users.Merchant;
import codes.java.entities.users.Student;
import java.time.LocalDateTime;

import static java.time.format.DateTimeFormatter.ofPattern;

// 订单类
public class Order {

    private int orderId;                // 订单ID
    private int quantity;               // 菜品数量
    private Student student;            // 下单学生
    private Merchant merchant;          // 接单商家
    private LocalDateTime orderTime;    // 下单时间
    private Dish dish;                  // 下单菜品
    private double totalPrice;          // 订单总金额
    private int status;                 // 订单状态 (1：下单成功，2：订单取消)
    private String address;             // 送餐地址
    private String phone;               // 学生电话


    // 构造函数
    public Order(Student student, Merchant merchant, LocalDateTime orderTime, Dish dish, int quantity, double totalPrice, int status, String address, String phone) {
        this.student = student;
        this.merchant = merchant;
        this.orderTime = orderTime;
        this.dish = dish;
        this.quantity = quantity;
        this.totalPrice = totalPrice;
        this.status = status;
        this.address = address;
        this.phone = phone;
    }

    // Getters
    public int getOrderId() {
        return orderId;
    }
    public Student getStudent() {
        return student;
    }
    public Merchant getMerchant() {
        return merchant;
    }
    public LocalDateTime getOrderTime() {
        return orderTime;
    }
    public Dish getDish() {
        return dish;
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
    public int getQuantity() {
        return quantity;
    }
    public String getPhone() {
        return phone;
    }

    // Setters
    public void setOrderID(int id) {
        this.orderId = id;
    }
    public void setStudent(Student student) {
        this.student = student;
    }
    public void setMerchant(Merchant merchant) {
        this.merchant = merchant;
    }


    @Override
    public String toString() {
        String statusStr = "";
        if (status == 1) {
            statusStr = "下单成功";
        } else {
            statusStr = "订单取消";
        }

        return  "订单号：" + orderId +
                "\n下单学生ID：" + student.getUserId() +
                "\n接单商家：" + merchant.getMerchantName() +
                "\n餐品：" + dish.getDishName() +
                "\n数量：" + quantity +
                "\n总金额：" + totalPrice +
                "\n顾客手机：" + phone +
                "\n下单时间：" + orderTime.format(ofPattern("yyyy-MM-dd HH:mm:ss")) +
                "\n送达地址：" + address +
                "\n订单状态：" + statusStr;
    }


}
