package main.java.utils.ForCSV;

import main.java.entities.Dish;
import main.java.entities.Order;
import main.java.entities.users.Merchant;
import main.java.entities.users.Student;
import main.java.entities.users.User;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.time.format.DateTimeFormatter;

/**
 * CSVReader类用于从CSV文件中读取数据
 */
public class CSVReader {

    private static final String USERS_CSV_PATH = "resources/sys/users.csv";
    private static final String DISHES_CSV_PATH = "resources/sys/dishes.csv";
    private static final String DISHES_TOP_10_PATH = "resources/python/csv/dishes_top_10.csv";
    private static final String ORDERS_CSV_PATH = "resources/sys/orders.csv";

    /**
     * 从文件中读取 ID
     */
    public static List<Integer> readIDs(String fileName) {
        String filePath;

        // 根据传入的文件名选择对应的CSV文件路径
        if (fileName.equals("users")) {
            filePath = USERS_CSV_PATH;
        } else if (fileName.equals("orders")) {
            filePath = ORDERS_CSV_PATH;
        } else {
            filePath = DISHES_CSV_PATH;
        }

        List<Integer> userIDs = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
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
                            String studentID = values[6];
                            return new Student(userID, username, password, phone, address, studentID);
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

    public static User readUserByUserID(int userID) {
        try (BufferedReader br = new BufferedReader(new FileReader(USERS_CSV_PATH))) {
            String line;
            br.readLine();
            while ((line = br.readLine()) != null) {
                if (line.trim().isEmpty()) {
                    continue;
                }
                String[] values = line.split(",");

                // 检查用户名是否匹配
                if (userID == Integer.parseInt(values[0].trim())) {
                    try {
                        String username = values[1];
                        String password = values[2];
                        String phone = values[3];
                        String address = values[4];
                        int role = Integer.parseInt(values[5]);

                        if (role == 0) {
                            String studentID = values[6];
                            return new Student(userID, username, password, phone, address, studentID);
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
            br.readLine();
            while ((line = br.readLine()) != null) {
                if (line.trim().isEmpty() || line.trim().startsWith("#")) {
                    continue;
                }
                String[] values = line.split(",");

                try {
                    int role = Integer.parseInt(values[5].trim());

                    // 检查是否为商家且地址匹配
                    if (role == 1) {
                        String address = values[7].trim();
                        if (address.equals(canteenAddress)) {
                            int userID = Integer.parseInt(values[0].trim());
                            String username = values[1].trim();
                            String password = values[2].trim();
                            String phone = values[3].trim();
                            String canteenOfMerchant = values[7].trim();
                            String location = values[8].trim();
                            merchantList.add(new Merchant(userID, username, password, phone, canteenOfMerchant, location));
                        }
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

    public static Dish readDishesByDishName(String dishName) {
        Dish dish = null;
        try (BufferedReader br = new BufferedReader(new FileReader(DISHES_CSV_PATH))) {
            String line;
            br.readLine();
            while ((line = br.readLine()) != null) {
                // 跳过空行或注释/标题行
                if (line.trim().isEmpty()) {
                    continue;
                }
                String[] values = line.split(",");
                try {
                    // 检查商家ID是否匹配 (列索引 3)
                    int csvMerchantID = Integer.parseInt(values[3].trim());
                    String csvDishName = values[1].trim();
                    if (csvDishName.equals(dishName)) {
                        int dishID = Integer.parseInt(values[0].trim());
                        double price = Double.parseDouble(values[2].trim());
                        int merchantID = Integer.parseInt(values[3].trim());
                        int stock = Integer.parseInt(values[4].trim());
                        int popularity = Integer.parseInt(values[5].trim());
                        dish = new Dish(dishID, dishName, price, merchantID, stock, popularity);
                    }
                } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
                    System.err.println("解析菜品数据时出错，行内容: " + line);
                }
            }
        } catch (IOException e) {
            System.err.println("读取 dishes.csv 文件时出错: " + e.getMessage());
        }
        return dish;
    }

    /**
     * 根据商家ID从 dishes.csv 文件中读取菜品列表。
     */
    public static List<Dish> readDishesByMerchantID(int merchantID) {
        List<Dish> dishList = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(DISHES_CSV_PATH))) {
            String line;
            br.readLine();
            while ((line = br.readLine()) != null) {
                // 跳过空行或注释/标题行
                if (line.trim().isEmpty()) {
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
                        int popularity = Integer.parseInt(values[5].trim());
                        dishList.add(new Dish(dishID, dishName, price, merchantID, stock, popularity));
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

    public static List<Order> readOrdersByUserID(int userID, int role) {
        List<Order> orderList = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(ORDERS_CSV_PATH))) {
            String line;
            br.readLine();
            while ((line = br.readLine()) != null) {
                // 跳过空行或注释/标题行
                if (line.trim().isEmpty()) {
                    continue;
                }
                String[] values = line.split(",");
                try {
                    // 检查用户ID是否匹配 (列索引 3)
                    int csvUserID = Integer.parseInt(values[role + 1].trim());
                    if (csvUserID == userID) {
                        int orderID = Integer.parseInt(values[0].trim());
                        int studentID = Integer.parseInt(values[1].trim());
                        int merchantID = Integer.parseInt(values[2].trim());
                        Student student = (Student) readUserByUserID(studentID);
                        Merchant merchant = (Merchant) readUserByUserID(merchantID);
                        String dishName = values[3].trim();
                        Dish dish = readDishesByDishName(dishName);
                        int quantity = Integer.parseInt(values[4].trim());
                        double totalPrice = Double.parseDouble(values[5].trim());

                        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                        LocalDateTime orderTime = LocalDateTime.parse(values[6].trim(), formatter);

                        int status = Integer.parseInt(values[7].trim());
                        orderList.add(new Order(orderID, student, merchant, dish, quantity, orderTime, totalPrice, status));
                    }
                } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
                    System.err.println("解析订单数据时出错，行内容: " + line);
                }
            }
        } catch (IOException e) {
            System.err.println("读取 orders.csv 文件时出错: " + e.getMessage());
        }
        return orderList;
    }

    public static List<Dish> readTOP10Dishes() {
        List<Dish> dishList = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(DISHES_TOP_10_PATH))) {
            String line;
            br.readLine();
            while ((line = br.readLine()) != null) {
                // 跳过空行或注释/标题行
                if (line.trim().isEmpty()) {
                    continue;
                }
                String[] values = line.split(",");
                try {
                    // 解析 csv 文件
                    int dishID = Integer.parseInt(values[0].trim());
                    String dishName = values[1].trim();
                    double price = Double.parseDouble(values[2].trim());
                    int merchantID = Integer.parseInt(values[3].trim());
                    int stock = Integer.parseInt(values[4].trim());
                    int popularity = Integer.parseInt(values[5].trim());
                    dishList.add(new Dish(dishID, dishName, price, merchantID, stock, popularity));
                } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
                    System.err.println("解析菜品数据时出错，行内容: " + line);
                }
            }
        } catch (IOException e) {
            System.err.println("读取 dishes_top_10.csv 文件时出错: " + e.getMessage());
        }
        return dishList;
    }
}
