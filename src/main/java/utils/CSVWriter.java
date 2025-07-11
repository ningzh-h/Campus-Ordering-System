package main.java.utils;

import main.java.entities.Dish;
import main.java.entities.Order;
import main.java.entities.users.Merchant;
import main.java.entities.users.Student;

import java.io.FileWriter;

public class CSVWriter {
    private static final String students_csv_path = "resources/input/students.csv";

    public static void intoCSV(Student student) {
        try (FileWriter fw = new FileWriter(students_csv_path, true)) {
            fw.append(String.join(",",
                    student.getUserID(),
                    student.getUsername(),
                    student.getPassword(),
                    student.getPhone(),
                    student.getAddress(),
                    student.getStudentID()
            ));
            fw.append("\n");
        } catch (Exception e) {
            System.out.println("写入数据失败！");
        }
    }

    public static void intoCSV(Merchant merchant) {}
    public static void intoCSV(Order order) {}
    public static void intoCSV(Dish dish) {}
}
