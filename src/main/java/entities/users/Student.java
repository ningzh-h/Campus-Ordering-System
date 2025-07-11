package main.java.entities.users;


// 学生类
public class Student extends User{
    private String studentID;    // 学生姓名

    // 构造函数
    public Student(String username, String password, String phone, String address, String studentID) {
        super(username, password, phone, address, 0);

//        super.setUserID(IDGenerator);

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
