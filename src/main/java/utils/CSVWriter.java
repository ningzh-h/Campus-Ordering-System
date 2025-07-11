package main.java.utils;

import main.java.entities.users.Merchant;
import main.java.entities.users.Student;
import main.java.entities.users.User;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * CSVWriter 类用于将数据写入 CSV 文件
 */
public class CSVWriter {
    private static final String USERS_CSV_PATH = "resources/sys/users.csv";
    private static final String DISHES_CSV_PATH = "resources/sys/dishes.csv";
    private static final String ORDERS_CSV_PATH = "resources/sys/orders.csv";

    /**
     * 将用户写入 users.csv 文件
     */
    public static void writeUser(User user) {
        // 使用 true 参数来开启追加模式
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(USERS_CSV_PATH, true))) {
            StringBuilder sb = new StringBuilder();

            sb.append(user.getUserId()).append(",");
            sb.append(user.getUsername()).append(",");
            sb.append(user.getPassword()).append(",");
            sb.append(user.getPhone()).append(",");
            sb.append(user.getAddress()).append(",");
            sb.append(user.getRole()).append(",");

            if (user instanceof Student student) {
                sb.append(student.getStudentID()).append(",");
                sb.append(",");
            } else if (user instanceof Merchant merchant) {
                sb.append(",");
                sb.append(merchant.getCanteen()).append(",");
                sb.append(merchant.getLocation());
            }
            bw.write(sb.toString());
            bw.newLine();
        } catch (IOException e) {
            System.err.println("追加写入 users.csv 文件时出错: " + e.getMessage());
        }
    }
}
