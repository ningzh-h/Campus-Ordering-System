package codes.java.entities;

// 菜品类
public class Dish {
    private static int nextId = 1;    // 用于生成下一个菜品ID的静态变量

    private final int dishId;
    private String dishName;
    private double price;
    private int merchantId;          // 菜品所属的商家ID
    private int stock;

    // 构造函数
    public Dish(String dishName, int price, int merchantId, int stock) {
        this.dishId = nextId++;
        this.dishName = dishName;
        this.price = price;
        this.merchantId = merchantId;
        this.stock = stock;
    }

    // Getters
    public int getDishId() {
        return dishId;
    }
    public String getDishName() {
        return dishName;
    }
    public double getPrice() {
        return price;
    }
    public int getMerchantId() {
        return merchantId;
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
    public void setMerchantId(int merchantId) {
        this.merchantId = merchantId;
    }
    public void setStock(int stock) {
        this.stock = stock;
    }

    @Override
    public String toString() {
        return dishName + ", 价格：" + price;
    }

}
