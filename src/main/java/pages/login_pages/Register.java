package main.java.pages.login_pages;

import main.java.entities.users.Merchant;
import main.java.entities.users.Student;
import main.java.entities.users.User;
import main.java.services.LoginService;
import main.java.utils.Input;

import java.util.Objects;

public class Register {
    User currentUser = null;
    LoginService loginService = new LoginService();

    // 新用户注册
    public User register() {
        System.out.println("\n=== 新用户注册 ===");
        System.out.println("1. 学生注册");
        System.out.println("2. 商家注册");
        System.out.println("0. 返回上一页");

        int roleChoice = Input.getInt("请选择：");
        switch (roleChoice) {
            case 0:
                return null;
            case 1:
                String userName_s;
                while (true) {
                    userName_s = Input.getString("请输入用户名：");
                    if (loginService.checkUsername(userName_s)) {
                        break;
                    } else {
                        System.out.println("该用户名已存在！");
                    }
                }

                String password_s = Input.getString("请输入密码：");
                String password2_s = Input.getString(("请再次输入密码："));
                while (!Objects.equals(password_s, password2_s)) {
                    System.out.println("两次输入的密码不一致！");
                    password_s = Input.getString("请输入密码：");
                    password2_s = Input.getString(("请再次输入密码："));
                }

                String phone_s = Input.getString("请输入您的电话：");
                String address_s = Input.getString("请输入您的地址：");
                String studentID = Input.getString("请输入您的学号：");

                Student student = new Student(userName_s, password_s, phone_s, address_s, studentID);

                loginService.register(student);
                System.out.println("学生注册成功！");
                currentUser = student;
                break;


            case 2:
                String userName_m;
                while (true) {
                    userName_m = Input.getString("请输入用户名：");
                    if (loginService.checkUsername(userName_m)) {
                        break;
                    } else {
                        System.out.println("该用户名已存在！");
                    }
                }

                String password_m = Input.getString("请输入密码：");
                String password2_m = Input.getString(("请再次输入密码："));
                while (!Objects.equals(password_m, password2_m)) {
                    System.out.println("两次输入的密码不一致！");
                    password_m = Input.getString("请输入密码：");
                    password2_m = Input.getString(("请再次输入密码："));
                }

                String phone_m = Input.getString("请输入您的电话：");

                String canteen = Input.getString("请输入店铺所在食堂：");
                String location = Input.getString("请输入您店铺的位置：");
                Merchant merchant = new Merchant(userName_m, password_m, phone_m, canteen, location);

                loginService.register(merchant);
                System.out.println("商家注册成功！");
                currentUser = merchant;
                break;


            default:
                System.out.println("无效选择。");
                break;
        }
        return currentUser;
    }
}
