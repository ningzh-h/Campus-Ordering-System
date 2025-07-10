package codes.java.pages.student_pages.student_info;

import codes.java.entities.users.User;
import codes.java.utils.Input;

public class StudentInfo {
    Input input = new Input();
    EditStudentInfo editStudentInfo = new EditStudentInfo();
    
    public void student_info(User currentUser) {
        System.out.println("=== 个人信息 ===");
        System.out.println("1. 用户名：" + currentUser.getUsername());
        System.out.println("2. 用户ID：" + currentUser.getUserId());
        System.out.println("3. 密码设置");
        System.out.println("4. 电话");
        System.out.println("5. 地址");
        System.out.println("6. 学号");
        System.out.println("0. 返回订餐系统");
        int choice = input.getInt("请选择");
        
        editStudentInfo.editInfo(currentUser, choice);
    }
}
