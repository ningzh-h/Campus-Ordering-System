package main.java.utils;

import main.java.entities.users.Merchant;
import main.java.entities.users.Student;
import main.java.entities.users.User;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * CSVReader类用于从CSV文件中读取数据
 */
public class CSVReader {

    private static final String USERS_CSV_PATH = "resources/sys/users.csv";

    /**
     * 从 users.csv文件中读取所有用户ID
     */
    public static List<Integer> readUserIDs() {
        List<Integer> userIDs = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(USERS_CSV_PATH))) {
            String line;
            br.readLine();
            while ((line = br.readLine()) != null) {
                // 跳过空行或注释/标题行
                if (line.trim().isEmpty()) {
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
            br.readLine();
            while ((line = br.readLine()) != null) {
                // 跳过空行或注释/标题行
                if (line.trim().isEmpty()) {
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
                        int userID = Integer.parseInt(values[0]);
                        String password = values[2];
                        String phone = values[3];
                        String address = values[4];
                        int role = Integer.parseInt(values[5]);

                        if (role == 0) {
                            String studentId = values[6];
                            return new Student(userID, username, password, phone, address, studentId);
                        }
                        if (role == 1) {
                            String canteen = values[7];
                            String location = values[8];
                            return new Merchant(userID, username, password, phone, canteen, location);
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
