package main.java.pages.merchant_pages.merchant_info;

import main.java.entities.users.Merchant;
import main.java.entities.users.User;
import main.java.utils.CSVModifier;
import main.java.utils.Input;

public class EditMerchantInfo {

    public void editInfo(Merchant currentUser, int choice) {
        int editChoice;
        switch (choice) {
            case 0:
                break;

            case 1:
                System.out.println("您的用户名为：" + currentUser.getUsername());
                System.out.println("1. 修改信息");
                System.out.println("0. 返回个人信息");
                editChoice = Input.getInt("请选择：");
                switch (editChoice) {
                    case 0 -> {}
                    case 1 -> currentUser.setUsername(Input.getString("请输入新的用户名："));
                    default -> System.out.println("无效选择");
                }
                break;

            case 4:
                System.out.println("您的电话为：" + currentUser.getPhone());
                System.out.println("1. 修改信息");
                System.out.println("0. 返回个人信息");
                editChoice = Input.getInt("请选择：");
                switch (editChoice) {
                    case 0 -> {}
                    case 1 -> currentUser.setPhone(Input.getString("请输入新的电话："));
                    default -> System.out.println("无效选择");
                }
                break;

            case 5:
                System.out.println("您的地址为：" + currentUser.getAddress());
                System.out.println("1. 修改所在食堂");
                System.out.println("2. 修改位置");
                System.out.println("0. 返回个人信息");
                editChoice = Input.getInt("请选择：");
                switch (editChoice) {
                    case 0 -> {}
                    case 1 -> currentUser.setCanteen(Input.getString("请输入新的所在食堂："));
                    case 2 -> currentUser.setLocation(Input.getString("请输入新的位置："));
                    default -> System.out.println("无效选择");
                }
                break;

            case 3:
                String oldPassword = Input.getString("请输入原本的密码：");
                String newPassword = Input.getString("请输入新的密码：");
                if (oldPassword.equals(newPassword)) {
                    System.out.println("原密码与新密码相同！");
                } else {
                    String newPasswordCheck = Input.getString("请再次确认新密码：");
                    if (newPassword.equals(newPasswordCheck)) {
                        currentUser.setPassword(newPassword);
                        System.out.println("修改密码成功！");
                    } else {
                        System.out.println("两次输入新密码不匹配！");
                    }
                }
                break;

            default:
                System.out.println("无效选择！");
                break;
        }
        CSVModifier.updateUser(currentUser);
    }
}
