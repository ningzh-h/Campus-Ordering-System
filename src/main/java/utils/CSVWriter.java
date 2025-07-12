package main.java.utils;

import main.java.entities.Dish;
import main.java.entities.Order;
import main.java.entities.users.Merchant;
import main.java.entities.users.Student;
import main.java.entities.users.User;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import static java.time.format.DateTimeFormatter.ofPattern;

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
    public static void write(User user) {
        // 使用 true 参数来开启追加模式
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(USERS_CSV_PATH, true))) {
            String userStr =
                user.getUserID() + "," +
                user.getUsername() + "," +
                user.getPassword() + "," +
                user.getPhone() + "," +
                user.getAddress() + "," +
                user.getRole() + ",";

            if (user instanceof Student student) {
                userStr += student.getStudentID() + ",,";
            } else if (user instanceof Merchant merchant) {
                userStr += "," + merchant.getCanteen() + "," + merchant.getLocation();
            }
            bw.write(userStr);
            bw.newLine();
        } catch (IOException e) {
            System.err.println("追加写入 users.csv 文件时出错: " + e.getMessage());
        }
    }

    /**
     * 将订单信息写入 orders.csv 文件。
     */
    public static void write(Order order) {
        // 使用 true 参数来开启追加模式
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(ORDERS_CSV_PATH, true))) {
            String orderStr = order.getOrderID() + "," +
                order.getStudent().getUserID() + "," +
                order.getMerchant().getUserID() + "," +
                order.getDish().getDishName() + "," +
                order.getQuantity() + "," +
                order.getTotalPrice() + "," +
                order.getOrderTime().format(ofPattern("yyyy-MM-dd HH:mm:ss")) + "," +
                order.getStatus();
            bw.write(orderStr);
            bw.newLine();
        } catch (IOException e) {
            System.err.println("写入 orders.csv 文件时出错: " + e.getMessage());
        }
    }

    public static void write(Dish dish) {
        // 使用 true 参数来开启追加模式
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(DISHES_CSV_PATH, true))) {
            String dishStr = dish.getDishID() + "," +
                    dish.getDishName() + "," +
                    dish.getPrice() + "," +
                    dish.getMerchantID() + "," +
                    dish.getStock() + "," +
                    dish.getPopularity();
            bw.write(dishStr);
            bw.newLine();
        } catch (IOException e) {
            System.err.println("写入 dishes.csv 文件时出错: " + e.getMessage());
        }
    }
}
