package codes.java.utils;

import codes.java.entities.users.Merchant;
import codes.java.entities.users.Student;
import codes.java.entities.users.User;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * CSVReader类用于从CSV文件中读取数据
 */
public class CSVReader {

    private static final String USERS_CSV_PATH = "src/data/input/users.csv";

    /**
     * 从 users.csv文件中读取所有用户ID
     */
    public static List<Integer> readUserIDs() {
        List<Integer> userIDs = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(USERS_CSV_PATH))) {
            String line;
            while ((line = br.readLine()) != null) {
                // 跳过空行或注释/标题行
                if (line.trim().isEmpty() || line.trim().startsWith("#")) {
                    continue;
                }
                String[] values = line.split(",");
                if (values.length > 0) {
                    try {
                        // 解析第一个值为用户ID
                        userIDs.add(Integer.parseInt(values[0].trim()));
                    } catch (NumberFormatException e) {
                        System.err.println("无法解析用户ID，行内容: " + line);
                    }
                }
            }
        } catch (IOException e) {
            System.err.println("读取 users.csv 文件时出错: " + e.getMessage());
        }
        return userIDs;
    }

    /**
     * 从 users.csv文件中读取所有用户名
     */
    public static List<String> readUserNames() {
        List<String> usernames = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(USERS_CSV_PATH))) {
            String line;
            while ((line = br.readLine()) != null) {
                // 跳过空行或注释/标题行
                if (line.trim().isEmpty() || line.trim().startsWith("#")) {
                    continue;
                }
                String[] values = line.split(",");
                usernames.add(values[1].trim());
            }
        } catch (IOException e) {
            System.err.println("读取 users.csv 文件时出错: " + e.getMessage());
        }
        return usernames;
    }

    /**
     * 根据用户名从 users.csv 文件中读取单个用户对象
     */
    public static User readUserByUsername(String username) {
        try (BufferedReader br = new BufferedReader(new FileReader(USERS_CSV_PATH))) {
            String line;
            // 跳过标题行
            br.readLine();
            while ((line = br.readLine()) != null) {
                if (line.trim().isEmpty()) {
                    continue;
                }
                String[] values = line.split(",");

                // 检查用户名是否匹配
                if (values[1].equals(username)) {
                    try {
                        int userId = Integer.parseInt(values[0]);
                        String password = values[2];
                        String phone = values[3];
                        String address = values[4];
                        int role = Integer.parseInt(values[5]);

                        if (role == 0) {
                            String studentId = values[6];
                            return new Student(userId, username, password, phone, address, studentId);
                        }
                        if (role == 1) {
                            String merchantName = values[7];
                            return new Merchant(userId, username, password, phone, address, merchantName);
                        }
                    } catch (NumberFormatException e) {
                        System.err.println("解析用户数据时出错，行内容: " + line);
                    }
                }
            }
        } catch (IOException e) {
            System.err.println("读取 users.csv 文件时出错: " + e.getMessage());
        }
        return null; // 未找到用户
    }



}
