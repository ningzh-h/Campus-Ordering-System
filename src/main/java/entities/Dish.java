package main.java.entities;

// 菜品类
public class Dish {
    private int dishID;
    private String dishName;
    private double price;
    private int merchantID;          // 菜品所属的商家ID
    private int stock;

    // 构造函数
    public Dish(String dishName, double price, int merchantId, int stock) {
        this.dishName = dishName;
        this.price = price;
        this.merchantID = merchantId;
        this.stock = stock;
    }

    public Dish(int dishID, String dishName, double price, int merchantId, int stock) {
        this.dishID = dishID;
        this.dishName = dishName;
        this.price = price;
        this.merchantID = merchantId;
        this.stock = stock;
    }

    // Getters
    public int getDishID() {
        return dishID;
    }
    public String getDishName() {
        return dishName;
    }
    public double getPrice() {
        return price;
    }
    public int getMerchantID() {
        return merchantID;
    }
    public int getStock() {
        return stock;
    }

    // Setters
    public void setDishName(String dishName) {
        this.dishName = dishName;
    }
    public void setPrice(int price) {
        this.price = price;
    }
    public void setMerchantID(int merchantID) {
        this.merchantID = merchantID;
    }
    public void setStock(int stock) {
        this.stock = stock;
    }

    @Override
    public String toString() {
        return dishName + ", 价格：" + price;
    }
}
