package codes.java.services;

import codes.java.entities.users.User;
import codes.java.utils.CSVGenerate;
import codes.java.utils.CSVReader;

import java.util.List;

public class LoginService {
    public LoginService() {
        System.out.println("来登录吧！");
    }

    /**
     * 用户登录认证
     */
    public User authenticate(String userName, String password) {
        User user = CSVReader.readUserByUsername(userName);
        if (user == null) {
            return null;  // 用户名不存在
        }

        // 检查密码是否匹配
        if (user.getPassword().equals(password)) {
            return user;
        } else {
            return null;  // 密码错误
        }
    }

    /**
     * 注册新用户
     */
    public boolean register(User user) {
        List<Integer> userIDs = CSVReader.readUserIDs();
        List<String> userNames = CSVReader.readUserNames();

        // 检查用户名是否已存在
        if (userNames.contains(user.getUsername())) {
            return false;
        }

        if (userIDs.isEmpty()) {
            user.setUserId(1);  // 如果用户列表为空，则ID从1开始设置
        } else {
            // 获取当前最大用户ID，并设置新用户ID为最大ID加1
            int maxUserId = userIDs.stream().max(Integer::compareTo).orElse(0);
            user.setUserId(maxUserId + 1);
        }
        CSVGenerate.writeUser(user);
        return true;
    }
}
