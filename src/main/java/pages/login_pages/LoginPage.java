package main.java.pages.login_pages;

import main.java.entities.users.User;
import main.java.utils.Input;


public class LoginPage {
    User currentUser = null;
    Login login = new Login();
    Register register = new Register();

    // 展示登录与注册页面
     public User showLoginPage() {
        System.out.println("\n=== 登录 ===");
        System.out.println("1. 登录");
        System.out.println("2. 注册");
        System.out.println("0. 退出");

        int choice = Input.getInt("请选择：");
        switch (choice) {
            case 1:
                currentUser = login.login();
                break;
            case 2:
                currentUser = register.register();
                break;
            case 0:
                System.out.println("感谢使用校园餐厅订餐系统，再见！");
                System.exit(0);
            default:
                System.out.println("无效选择，请重新输入。");
        }
        return currentUser;
    }
}
