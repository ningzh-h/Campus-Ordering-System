package main.java.services;

import main.java.entities.users.User;
import main.java.utils.CSVWriter;
import main.java.utils.CSVReader;

import java.util.List;

public class LoginService {
    /**
     * 用户登录认证
     */
    public User authenticate(String username, String password) {
        User user = CSVReader.readUserByUsername(username);
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
    public void register(User user) {
        List<Integer> userIDs = CSVReader.readIDs("users");

        if (userIDs.isEmpty()) {
            user.setUserID(1);  // 如果用户列表为空，则ID从1开始设置
        } else {
            // 获取当前最大用户ID，并设置新用户ID为最大ID加1
            int maxUserID = userIDs.stream().max(Integer::compareTo).orElse(0);
            user.setUserID(maxUserID + 1);
        }
        CSVWriter.writeUser(user);
    }

    /**
     * 检查用户名是否已经存在
     */
    public boolean checkUsername(String username) {
        List<String> usernames = CSVReader.readUserNames();
        // 检查用户名是否已存在
        return !usernames.contains(username);
    }
}
