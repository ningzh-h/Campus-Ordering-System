package main.java.utils.ForCSV;

import main.java.entities.Dish;
import main.java.entities.users.Merchant;
import main.java.entities.users.Student;
import main.java.entities.users.User;

import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class CSVUpdater {
    private static final String USERS_CSV_PATH = "resources/sys/users.csv";
    private static final String DISHES_CSV_PATH = "resources/sys/dishes.csv";
    private static final String ORDERS_CSV_PATH = "resources/sys/orders.csv";
    private static final String TEMP_CSV_PATH = "resources/sys/temp.csv";
    private static final String USERS_CSV_HEADER = "user_id,username,password,phone,address,role,student_id,canteen,location";
    private static final String DISHES_CSV_HEADER = "dish_id,dish_name,price,merchant_id,stock,popularity";

    /**
     * 根据参数 userID 找出原 user 所在的 csv 行, 并将其替换
     */
    public static void update(User user) {
        File inputFile = new File(USERS_CSV_PATH);
        File tempFile = new File(TEMP_CSV_PATH);
        try (BufferedReader br = new BufferedReader(new FileReader(inputFile));
             BufferedWriter bw = new BufferedWriter(new FileWriter(tempFile))) {

            // 写入标题行
            String header = br.readLine();
            bw.write(header != null ? header : USERS_CSV_HEADER);
            bw.newLine();

            String line;
            boolean found = false;
            while ((line = br.readLine()) != null) {
                if (line.trim().isEmpty()) {
                    continue;
                }
                String[] values = line.split(",");

                try {
                    int userID = Integer.parseInt(values[0].trim());
                    int role = Integer.parseInt(values[5].trim());
                    String userStr;

                    if (userID == user.getUserID()) {
                        values[1] = user.getUsername();
                        values[2] = user.getPassword();
                        values[3] = user.getPhone();
                        values[4] = user.getAddress();
                        if (user instanceof Student student) {
                            values[6] = student.getStudentID();
                        } else if (user instanceof Merchant merchant) {
                            values[7] = merchant.getCanteen();
                            values[8] = merchant.getLocation();
                        }
                        found = true;
                    }

                    userStr = String.join(",", values);
                    if (role == 0) {
                        userStr += ",,";
                    }
                    bw.write(userStr);
                    bw.newLine();
                } catch (Exception e) {
                    System.err.println("无效行！");
                }
            }

            if (!found) {
                System.err.println("未找到该用户ID！");
            }

        } catch (IOException e) {
            System.err.println("更新 users.csv 时出错: " + e.getMessage());
        }

        if (inputFile.delete()) {
            if (tempFile.renameTo(inputFile)) {
                System.out.println("用户信息更新成功！");
            } else {
                System.err.println("重命名临时文件失败！");
            }
        } else {
            System.err.println("删除原始文件失败！");
            if(!tempFile.delete()) {
                System.err.println("删除临时文件失败，请手动清理！");
            }
        }
    }

    // 重载 update
    public static void update(Dish dish) {
        File inputFile = new File(DISHES_CSV_PATH);
        File tempFile = new File(TEMP_CSV_PATH);
        try (BufferedReader br = new BufferedReader(new FileReader(inputFile));
             BufferedWriter bw = new BufferedWriter(new FileWriter(tempFile))) {

            // 写入标题行
            String header = br.readLine();
            bw.write(header != null ? header : DISHES_CSV_HEADER);
            bw.newLine();

            String line;
            boolean found = false;
            while ((line = br.readLine()) != null) {
                if (line.trim().isEmpty()) {
                    continue;
                }
                String[] values = line.split(",");

                try {
                    int dishID = Integer.parseInt(values[0].trim());

                    if (dishID == dish.getDishID()) {
                        values[1] = dish.getDishName();
                        values[2] = String.valueOf(dish.getPrice());
                        values[3] = String.valueOf(dish.getMerchantID());
                        values[4] = String.valueOf(dish.getStock());
                        values[5] = String.valueOf(dish.getPopularity());

                        found = true;
                    }

                    bw.write(String.join(",", values));
                    bw.newLine();
                } catch (Exception e) {
                    System.err.println("无效行！");
                }
            }

            if (!found) {
                System.err.println("未找到该菜品ID！");
            }

        } catch (IOException e) {
            System.err.println("更新 dishes.csv 时出错: " + e.getMessage());
        }

        if (inputFile.delete()) {
            if (tempFile.renameTo(inputFile)) {
                System.out.println("用户信息更新成功！");
            } else {
                System.err.println("重命名临时文件失败！");
            }
        } else {
            System.err.println("删除原始文件失败！");
            if(!tempFile.delete()) {
                System.err.println("删除临时文件失败，请手动清理！");
            }
        }
    }

    public static void delete(Dish dish) {
        File inputFile = new File(DISHES_CSV_PATH);
        File tempFile = new File(TEMP_CSV_PATH);
        try (BufferedReader br = new BufferedReader(new FileReader(inputFile));
             BufferedWriter bw = new BufferedWriter(new FileWriter(tempFile))) {

            // 写入标题行
            String header = br.readLine();
            bw.write(header != null ? header : DISHES_CSV_HEADER);
            bw.newLine();

            String line;
            while ((line = br.readLine()) != null) {
                if (line.trim().isEmpty()) {
                    continue;
                }
                String[] values = line.split(",");

                try {
                    int dishID = Integer.parseInt(values[0].trim());

                    if (dishID != dish.getDishID()) {
                        bw.write(String.join(",", values));
                    }

                    bw.newLine();
                } catch (Exception e) {
                    System.err.println("无效行！");
                }
            }
        } catch (IOException e) {
            System.err.println("更新 dishes.csv 时出错: " + e.getMessage());
        }

        if (inputFile.delete()) {
            if (tempFile.renameTo(inputFile)) {
                System.out.println("用户信息更新成功！");
            } else {
                System.err.println("重命名临时文件失败！");
            }
        } else {
            System.err.println("删除原始文件失败！");
            if(!tempFile.delete()) {
                System.err.println("删除临时文件失败，请手动清理！");
            }
        }
    }

    /**
     * 根据订单ID更新订单状态，将状态设置为newStatus
     */
    public static void updateOrderStatus(int orderID, int newStatus) {
        File orderFile = new File(ORDERS_CSV_PATH);
        List<String> lines = new ArrayList<>();
        boolean found = false;

        // 1. 将整个文件读入内存
        try (BufferedReader br = new BufferedReader(new FileReader(orderFile))) {
            String line;
            while ((line = br.readLine()) != null) {
                lines.add(line);
            }
        } catch (IOException e) {
            System.err.println("读取 orders.csv 文件时出错: " + e.getMessage());
            return;
        }

        // 2. 在内存中查找并修改行
        for (int i = 1; i < lines.size(); i++) { // 从 1 开始跳过标题行
            String line = lines.get(i);
            if (line.trim().isEmpty()) {
                continue;
            }
            String[] values = line.split(",");
            try {
                int currentOrderID = Integer.parseInt(values[0].trim());
                if (currentOrderID == orderID) {
                    values[7] = String.valueOf(newStatus); // 将 status 设置为 newStatus
                    lines.set(i, String.join(",", values));
                    found = true;
                    break; // 找到后即可退出循环
                }
            } catch (NumberFormatException e) {
                System.err.println("解析订单ID时出错，跳过无效行: " + line);
            }
        }

        // 3. 如果找到，则将修改后的内容写回原文件
        if (found) {
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(orderFile, false))) { // false 表示覆盖文件
                for (String line : lines) {
                    bw.write(line);
                    bw.newLine();
                }
            } catch (IOException e) {
                System.err.println("写回 orders.csv 文件时出错: " + e.getMessage());
            }
        } else {
            System.err.println("未找到订单ID: " + orderID);
        }
    }

}
