package main.java.utils;

import main.java.entities.users.Merchant;
import main.java.entities.users.Student;
import main.java.entities.users.User;

import java.io.*;


public class CSVModifier {
    private static final String USERS_CSV_PATH = "resources/sys/users.csv";
    private static final String DISHES_CSV_PATH = "resources/sys/dishes.csv";
    private static final String ORDERS_CSV_PATH = "resources/sys/orders.csv";
    private static final String TEMP_CSV_PATH = "resources/sys/temp.csv";
    private static final String CSV_HEADER = "user_id,user_name,password,phone,address,role,student_id,canteen,location";

    /**
     * 根据参数 userID 找出原 user 所在的 csv 行, 并将其替换
     */
    public static void updateUser(User user) {
        File inputFile = new File(USERS_CSV_PATH);
        File tempFile = new File(TEMP_CSV_PATH);
        try (BufferedReader br = new BufferedReader(new FileReader(inputFile));
             BufferedWriter bw = new BufferedWriter(new FileWriter(tempFile))) {

            // 写入标题行
            String header = br.readLine();
            bw.write(header != null ? header : CSV_HEADER);
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

                    bw.write(String.join(",", values));
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
}
