package codes.java.entities.users;

// 商家类
public class Merchant extends User {
    private String merchantName;      // 商家名称

    // 构造函数
    public Merchant(String username, String password, String phone, String address, String merchantName) {
        super(username, password, phone, address);
        super.setRole(1);
        this.merchantName = merchantName;
    }

    // 重载构造函数 - 用于登录验证
    public Merchant(int userID, String username, String password, String phone, String address, String merchantName) {
        super(username, password, phone, address);
        super.setUserId(userID);
        super.setRole(1);
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
