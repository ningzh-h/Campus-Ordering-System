package main.java.entities.users;

// 商家类
public class Merchant extends User {
    String canteen;
    String location;

    // 构造函数
    public Merchant(String username, String password, String phone, String canteen, String location) {
        super(username, password, phone, canteen + location);
        super.setRole(1);
        this.canteen = canteen;
        this.location = location;
    }

    // 重载构造函数 - 用于登录验证
    public Merchant(int userID, String username, String password, String phone, String canteen, String location) {
        super(username, password, phone, canteen + location);
        super.setUserId(userID);
        super.setRole(1);
        this.canteen = canteen;
        this.location = location;
    }

    // Getters
    public String getCanteen() {
        return canteen;
    }
    public String getLocation() {
        return location;
    }

    // Setters
    public void setCanteen(String canteen) {
        this.canteen = canteen;
    }
    public void setLocation(String location) {
        this.location = location;
    }
}
