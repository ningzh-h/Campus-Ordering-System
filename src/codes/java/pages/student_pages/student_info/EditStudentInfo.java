package codes.java.pages.student_pages.student_info;

import codes.java.entities.users.User;
import codes.java.utils.Input;

public class EditStudentInfo {
    Input input = new Input();
    
    public void editInfo(User currentUser, int choice) {
        int editChoice=0;
        switch (choice) {
            case 0:
                break;
                
            case 1: 
                System.out.println("您的用户名为：" + currentUser.getUsername());
                System.out.println("1. 修改信息");
                System.out.println("0. 返回个人信息");
                editChoice = input.getInt("请选择：");
                switch (editChoice) {
                    case 0 -> {}
                    case 1 -> currentUser.setUsername(input.getString("请输入新的用户名"));
                    default -> System.out.println("无效选择");
                }
                break;
                
            case 4:
                System.out.println("您的电话为：" + currentUser.getPhone());
                System.out.println("1. 修改信息");
                System.out.println("0. 返回个人信息");
                editChoice = input.getInt("请选择：");
                switch (editChoice) {
                    case 0 -> {}
                    case 1 -> currentUser.setUsername(input.getString("请输入新的电话"));
                    default -> System.out.println("无效选择");
                }
                break;

            case 5:
                System.out.println("您的地址为：" + currentUser.getAddress());
                System.out.println("1. 修改信息");
                System.out.println("0. 返回个人信息");
                editChoice = input.getInt("请选择：");
                switch (editChoice) {
                    case 0 -> {}
                    case 1 -> currentUser.setUsername(input.getString("请输入新的电话"));
                    default -> System.out.println("无效选择");
                }
                break;

            case 3:
                String oldPassword = input.getString("请输入原本的密码：");
                String newPassword = input.getString("请输入新的密码：");
                if (oldPassword.equals(newPassword)) {
                    System.out.println("原密码与新密码相同！");
                    return;
                } else {
                    String newPasswordCheck = input.getString("请再次确认新密码：");
                    if (newPassword.equals(newPasswordCheck)) {
                        currentUser.setPassword(newPassword);
                        System.out.println("修改密码成功！");
                        return;
                    } else {
                        System.out.println("两次输入新密码不匹配！");
                        return;
                    }
                }
            default:
                System.out.println("无效选择！");
                break;
        }
    }
}
