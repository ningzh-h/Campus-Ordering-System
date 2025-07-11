package codes.java.pages.login_pages;

import codes.java.entities.users.Merchant;
import codes.java.entities.users.Student;
import codes.java.entities.users.User;
import codes.java.services.LoginService;
import codes.java.utils.Input;

import java.util.Objects;

public class Register {
    User currentUser = null;
    Input input = new Input();
    LoginService loginService = new LoginService();

    // 新用户注册
    public User register() {
        System.out.println("\n=== 新用户注册 ===");
        System.out.println("1. 学生注册");
        System.out.println("2. 商家注册");
        System.out.println("0. 返回上一页");

        int roleChoice = input.getInt("请选择：");
        switch (roleChoice) {
            case 0:
                return null;
            case 1:
                String userName_s = input.getString("请输入用户名：");
                String password_s = input.getString("请输入密码：");
                String password2_s = input.getString(("请再次输入密码："));

                while (!Objects.equals(password_s, password2_s)) {
                    System.out.println("两次输入的密码不一致！");
                    password_s = input.getString("请输入密码：");
                    password2_s = input.getString(("请再次输入密码："));
                }

                String phone_s = input.getString("请输入您的电话：");
                String address_s = input.getString("请输入您的地址：");

                String studentID = input.getString("请输入您的学号：");
                Student student = new Student(userName_s, password_s, phone_s, address_s, studentID);

                if (loginService.register(student)) {
                    System.out.println("学生注册成功！");
                    currentUser = student;
                } else {
                    System.out.println("注册失败，该用户名已存在！");
                }
                break;
            case 2:
                String userName_m = input.getString("请输入用户名：");
                String password_m = input.getString("请输入密码：");
                String password2_m = input.getString(("请再次输入密码："));

                while (!Objects.equals(password_m, password2_m)) {
                    System.out.println("两次输入的密码不一致！");
                    password_m = input.getString("请输入密码：");
                    password2_m = input.getString(("请再次输入密码："));
                }

                String phone_m = input.getString("请输入您的电话：");
                String address_m = input.getString("请输入您的所属食堂（如：一食堂）：");

                String shopName = input.getString("请输入您的店铺名称：");
                Merchant merchant = new Merchant(userName_m, password_m, phone_m, address_m, shopName);

                if (loginService.register(merchant)) {
                    System.out.println("商家注册成功！");
                    currentUser = merchant;
                } else {
                    System.out.println("注册失败，该用户名已存在！");
                }
                break;
            default:
                System.out.println("无效选择。");
                break;
        }
        return currentUser;
    }
}
