package main.java.pages.login_pages;

import main.java.entities.users.User;
import main.java.services.LoginService;
import main.java.utils.Input;


public class Login {
    User currentUser = null;
    LoginService loginService = new LoginService();

    // 用户登录
    public User login() {
        // 交互菜单
        String username = Input.getString("请输入用户名：");

        String password = Input.getString("请输入密码：");

        currentUser = loginService.authenticate(username, password);
        if (currentUser != null) {
            System.out.println("登录成功！欢迎您, " + username);
        } else {
            System.out.println("密码或用户名错误！");
        }
        return currentUser;
    }
}
