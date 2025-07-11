package main.java.entities.users;

// 商家类
public class Merchant extends User {
    private String merchantName;      // 商家名称

    // 构造函数
    public Merchant(String username, String password, String phone, String address, String merchantName) {
        super(username, password, phone, address);
        this.merchantName = merchantName;
    }

    // Getters
    public String getMerchantName() {
        return merchantName;
    }

    // Setters
    public void setMerchantName(String merchantName) {
        this.merchantName = merchantName;
    }
}
