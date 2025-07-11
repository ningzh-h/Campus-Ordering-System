package main.java.entities.users;

// 用户类
public class User {
    private static int nextID;
    private String userID;
    private String username;  // 用户名，用于登录系统
    private String password;
    private String phone;
    private String address;
    private int role;         // 0代表学生，1代表商家

    public User(String username, String password, String phone, String address, int role) {
        this.username = username;
        this.password = password;
        this.phone = phone;
        this.address = address;
        this.role = role;
    }


    // Getters
    public String getUserID() {
        return userID;
    }
    public String getUsername() {
        return username;
    }
    public String getPassword() {
        return password;
    }
    public String getPhone() {
        return phone;
    }
    public String getAddress() {
        return address;
    }
    public int getRole() {
        return role;
    }

    // Setters
    public void setUserID(String userID) {
        this.userID = userID;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public void setRole(int role) {
        this.role = role;
    }
}
