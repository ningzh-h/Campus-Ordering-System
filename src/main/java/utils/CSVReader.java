package main.java.utils;

import main.java.entities.Dish;
import main.java.entities.Order;
import main.java.entities.users.Merchant;
import main.java.entities.users.Student;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CSVReader {

    public static List<Student> readStudents(String csv_path) {
        List<Student> students = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(csv_path))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                if (data[0].charAt(0) == '0') {
                    students.add(new Student(data[1], data[2], data[3], data[4], data[5]));
                    System.out.println(Arrays.toString(data));
                }
            }
            return students;
        } catch (Exception e) {
            System.out.println("暂无数据");
            return null;
        }
    }

    public static List<Merchant> readMerchants(String csv_path) {
        List<Merchant> merchants = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(csv_path))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                if (data[0].charAt(0) == '0') {
                    merchants.add(new Merchant(data[1], data[2], data[3], data[4], data[5]));
                    System.out.println(Arrays.toString(data));
                }
            }
            return merchants;
        } catch (Exception e) {
            System.out.println("暂无数据");
            return null;
        }
    }

//    public static List<Order> readOrders(String orders_csv_path) {}

//    public static List<Dish> readDishes(String dishes_csv_path) {}

}
