package codes.java.pages.login_pages;

import codes.java.entities.users.User;
import codes.java.services.LoginService;

import java.util.Scanner;

public class Login {
    Scanner scanner = new Scanner(System.in);
    User currentUser = null;
    LoginService loginService = new LoginService();

    // 用户登录
    public User login() {
        // 交互菜单
        System.out.println("请输入用户名：");
        String userName = scanner.nextLine();
        System.out.println("请输入密码：");
        String password = scanner.nextLine();

        // TODO: 登录验证逻辑待实现
        currentUser = loginService.authenticate(userName, password);
        if (currentUser != null) {
            System.out.println("登录成功！欢迎您, " + userName);
        } else {
            System.out.println("密码或用户名错误！");
        }
        return currentUser;
    }
}
