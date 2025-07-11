package codes.java.utils;

import codes.java.entities.Dish;
import codes.java.entities.Order;
import codes.java.entities.users.Merchant;
import codes.java.entities.users.Student;
import codes.java.entities.users.User;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import static java.time.format.DateTimeFormatter.ofPattern;

/**
 * CSVGenerate 类用于将数据写入 CSV 文件
 */
public class CSVGenerate {

    private static final String USERS_CSV_PATH = "src/data/input/users.csv";
    private static final String DISHES_CSV_PATH = "src/data/input/dishes.csv";
    private static final String ORDERS_CSV_PATH = "src/data/input/orders.csv";


    /**
     * 将用户写入 users.csv 文件
     */
    public static void writeUser(User user) {
        // 使用 true 参数来开启追加模式
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(USERS_CSV_PATH, true))) {
            String userStr = user.getUserId() + "," +
                    user.getUsername() + "," +
                    user.getPassword() + "," +
                    user.getPhone() + "," +
                    user.getAddress() + "," +
                    user.getRole() + ",";

            if (user instanceof Student student) {
                userStr += student.getStudentID() + ",NULL"; // 学生没有 merchantName 字段
            } else if (user instanceof Merchant merchant) {
                userStr += "NULL," + merchant.getMerchantName(); // 商家没有 studentId 字段
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
    public static void writeOrder(Order order) {
        // 使用 true 参数来开启追加模式
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(ORDERS_CSV_PATH, true))) {
            String orderStr = order.getOrderId() + "," +
                    order.getStudent().getUserId() + "," +
                    order.getMerchant().getUserId() + "," +
                    order.getDish().getDishName() + "," +
                    order.getQuantity() + "," +
                    order.getTotalPrice() + "," +
                    order.getOrderTime().format(ofPattern("yyyy-MM-dd HH:mm:ss")) + "," +
                    order.getAddress() + "," +
                    order.getPhone() + "," +
                    order.getStatus();
            bw.write(orderStr);
            bw.newLine();
        } catch (IOException e) {
            System.err.println("写入 orders.csv 文件时出错: " + e.getMessage());
        }
    }






}