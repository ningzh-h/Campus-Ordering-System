package main.java.entities.users;


// 学生类
public class Student extends User{
    private String studentID;    // 学号

    // 构造函数
    public Student(String username, String password, String phone, String address, String studentID) {
        super(username, password, phone, address);
        super.setRole(0);
        this.studentID = studentID;
    }

    // 重载构造函数 - 用于登录验证
    public Student(int userID, String username, String password, String phone, String address, String studentID) {
        super(username, password, phone, address);
        super.setUserId(userID);
        super.setRole(0);
        this.studentID = studentID;
    }

    // Getters
    public String getStudentID() {
        return studentID;
    }

    // Setters
    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }
}
