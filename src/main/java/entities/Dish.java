package main.java.entities;

// 菜品类
public class Dish {
    private int dishID;
    private String dishName;
    private double price;
    private int merchantID;          // 菜品所属的商家ID
    private int stock;
    private int popularity;

    // 构造函数
    public Dish(String dishName, double price, int merchantID, int stock, int popularity) {
        this.dishName = dishName;
        this.price = price;
        this.merchantID = merchantID;
        this.stock = stock;
        this.popularity = popularity;
    }

    public Dish(int dishID, String dishName, double price, int merchantID, int stock, int popularity) {
        this.dishID = dishID;
        this.dishName = dishName;
        this.price = price;
        this.merchantID = merchantID;
        this.stock = stock;
        this.popularity = popularity;
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
    public int getPopularity() {
        return popularity;
    }

    // Setters
    public void setDishID(int dishID) {
        this.dishID = dishID;
    }
    public void setDishName(String dishName) {
        this.dishName = dishName;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public void setMerchantID(int merchantID) {
        this.merchantID = merchantID;
    }
    public void setStock(int stock) {
        this.stock = stock;
    }
    public void setPopularity(int quantity) {
        popularity += quantity;
    }
    public void resetPopularity() {
        popularity = 0;
    }


    @Override
    public String toString() {
        return dishName + ", 价格：" + price + "元";
    }
}
