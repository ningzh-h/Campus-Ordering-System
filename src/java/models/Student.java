package java.models;

// 学生类
public class Student extends User{
    private String studentName;    // 学生姓名

    // 构造函数
    public Student(String username, String password, String phone, String address, String studentName) {
        super(username, password, phone, address);
        this.studentName = studentName;
    }

    // Getters
    public String getStudentName() {
        return studentName;
    }

    // Setters
    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }
}
