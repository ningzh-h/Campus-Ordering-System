package main.java.pages.student_pages.student_info;

import main.java.entities.users.Student;
import main.java.utils.Input;

public class StudentInfo {
    EditStudentInfo editStudentInfo = new EditStudentInfo();
    
    public void studentInfo(Student currentUser) {
        System.out.println("=== 个人信息 ===");
        System.out.println("1. 用户名：" + currentUser.getUsername());
        System.out.println("2. 用户ID：" + currentUser.getUserId());
        System.out.println("3. 密码设置");
        System.out.println("4. 电话");
        System.out.println("5. 地址");
        System.out.println("6. 学号");
        System.out.println("0. 返回订餐系统");
        int choice = Input.getInt("请选择");
        
        editStudentInfo.editInfo(currentUser, choice);
    }
}
