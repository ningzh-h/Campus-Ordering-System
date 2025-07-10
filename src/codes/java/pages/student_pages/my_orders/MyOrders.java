package codes.java.pages.student_pages.my_orders;

import codes.java.entities.Order;
import codes.java.entities.users.User;
import codes.java.services.StudentService;
import codes.java.utils.Input;

import java.util.List;
import java.util.Scanner;

public class MyOrders {
    Input input = new Input();
    Scanner scanner = new Scanner(System.in);
    StudentService studentService = new StudentService();
    List<Order> studentOrders;
    Order orderChosen;

    public void myOrders(User currentUser) {
        while (true) {
            System.out.println("\n=== 我的订单 ===");
            // TODO: StudentService 获取学生的历史订单
//        studentOrders = studentService.getOrdersByUserID(currentUser.userID);
            try {

                int len = studentOrders.size();
                for (int i = 0; i < len; i++) {
                    System.out.println((i + 1) + ". " + studentOrders.get(i).toString());
                }
            } catch (Exception e) {
                System.out.println("暂无数据");
            }

            System.out.println("0. 返回订餐系统");

            int choice = input.getInt("选择订单可查看详情：");

            try {
                if (choice != 0) {
                    orderChosen = studentOrders.get(choice-1);
                    // TODO: Order 的 toTable() 方法
//                    orderChosen.toTable();
                    System.out.println("按任意键返回...");
                    scanner.nextLine();
                } else {
                    return;
                }
            } catch (Exception e) {
                System.out.println("无效选择！");
            }
        }
    }
}
