package codes.java.utils;

import codes.java.entities.Dish;
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
    private static final String DISHES_CSV_PATH = "src/data/input/dishes.csv";
    private static final String ORDERS_CSV_PATH = "src/data/input/orders.csv";

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

    /**
     * 根据食堂编号从 users.csv 文件中读取商家列表
     */
    public static List<Merchant> readMerchantByCanteen(int canteen) {
        List<Merchant> merchantList = new ArrayList<>();
        String canteenAddress;

        switch (canteen) {
            case 1:
                canteenAddress = "一食堂";
                break;
            case 2:
                canteenAddress = "二食堂";
                break;
            case 3:
                canteenAddress = "三食堂";
                break;
            case 4:
                canteenAddress = "四食堂";
                break;
            default:
                // 如果食堂编号无效，返回空列表
                return merchantList;
        }

        try (BufferedReader br = new BufferedReader(new FileReader(USERS_CSV_PATH))) {
            String line;
            while ((line = br.readLine()) != null) {
                // 跳过空行或注释/标题行
                if (line.trim().isEmpty() || line.trim().startsWith("#")) {
                    continue;
                }
                String[] values = line.split(",");

                try {
                    int role = Integer.parseInt(values[5].trim());
                    String address = values[4].trim();

                    // 检查是否为商家且地址匹配
                    if (role == 1 && address.equals(canteenAddress)) {
                        int userId = Integer.parseInt(values[0].trim());
                        String username = values[1].trim();
                        String password = values[2].trim();
                        String phone = values[3].trim();
                        String merchantName = values[7].trim();
                        merchantList.add(new Merchant(userId, username, password, phone, address, merchantName));
                    }
                } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
                    System.err.println("解析商家数据时出错，行内容: " + line);
                }
            }
        } catch (IOException e) {
            System.err.println("读取 users.csv 文件时出错: " + e.getMessage());
        }
            return merchantList;
    }

    /**
     * 根据商家ID从 dishes.csv文件中读取菜品列表。
     */
    public static List<Dish> readDishesByMerchantID(int merchantID) {
        List<Dish> dishList = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(DISHES_CSV_PATH))) {
            String line;
            while ((line = br.readLine()) != null) {
                // 跳过空行或注释/标题行
                if (line.trim().isEmpty() || line.trim().startsWith("#")) {
                    continue;
                }
                String[] values = line.split(",");
                try {
                    // 检查商家ID是否匹配 (列索引 3)
                    int csvMerchantID = Integer.parseInt(values[3].trim());
                    if (csvMerchantID == merchantID) {
                        int dishID = Integer.parseInt(values[0].trim());
                        String dishName = values[1].trim();
                        double price = Double.parseDouble(values[2].trim());
                        int stock = Integer.parseInt(values[4].trim());
                        dishList.add(new Dish(dishID, dishName, price, merchantID, stock));
                    }
                } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
                    System.err.println("解析菜品数据时出错，行内容: " + line);
                }
            }
        } catch (IOException e) {
            System.err.println("读取 dishes.csv 文件时出错: " + e.getMessage());
        }
        return dishList;
    }



}
