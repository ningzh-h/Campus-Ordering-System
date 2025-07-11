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
        String userName = Input.getString("请输入用户名");

        System.out.println("请输入密码：");
        String password = Input.getString("请输入密码");

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
