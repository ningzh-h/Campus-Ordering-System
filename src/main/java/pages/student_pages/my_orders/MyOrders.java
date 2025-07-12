package main.java.pages.student_pages.my_orders;

import main.java.entities.Order;
import main.java.entities.users.Student;
import main.java.services.OrderService;
import main.java.utils.CSVReader;
import main.java.utils.Input;
import java.util.List;
import java.util.Scanner;


public class MyOrders {
    Scanner scanner = new Scanner(System.in);
    OrderService orderService = new OrderService();
    List<Order> studentOrders;
    Order orderChosen;

    public void myOrders(Student currentUser) {
        while (true) {
            System.out.println("\n=== 我的订单 ===");
            studentOrders = CSVReader.readOrdersByUserID(currentUser.getUserID(), currentUser.getRole());

            int len = studentOrders.size();
            for (int i = 0; i < len; i++) {

                try {
                    System.out.println((i + 1) + ". " + studentOrders.get(i).toString());
                    System.out.println("------------------------------");
                } catch (NullPointerException e) {
                    System.out.println("订单 " + (i + 1) + " 已经被删除或不存在");
                    System.out.println("------------------------------");
                    // 这里用continue来跳过那些菜品已经被商家删除的历史订单，经测试，按原逻辑异常订单之后的正常订单无法展示
                    continue;
                }
            }

            System.out.println("0. 返回订餐系统");
            int choice = Input.getInt("请选择您要取消的订单序号：");

            try {
                if (choice != 0) {
                    orderService.cancelOrder(studentOrders.get(choice - 1));
                } else {
                    return;
                }
            } catch (Exception e) {
                System.out.println("无效选择！");
            }
        }
    }
}
