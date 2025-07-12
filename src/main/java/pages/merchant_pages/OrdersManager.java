package main.java.pages.merchant_pages;

import main.java.entities.Order;
import main.java.entities.users.Merchant;
import main.java.services.UserService;
import main.java.utils.Input;

import java.util.List;
import java.util.Scanner;

public class OrdersManager {
    Scanner scanner = new Scanner(System.in);
    UserService userService = new UserService();
    List<Order> orders;

    public void ordersManager(Merchant currentUser) {
        // TODO: UserService 获取学生的商家订单
//        orders = userService.getOrdersByUserID(currentUser.getUserId());

        System.out.println("=== 订单处理 ===");
        System.out.println("1. 当前订单");
        System.out.println("2. 历史订单");
        System.out.println("0. 返回管理系统");
        int choice = Input.getInt("请选择：");

        switch (choice) {
            case 0:
                break;

            case 1:
                while (true) {
                    try {
                        // TODO: 根据订单状态显示订单
                        orders = null;
                        int len = orders.size();
                        int j = 0;
                        for (Order order : orders) {
                            if (order.getStatus() == choice) {
                                System.out.println((j + 1) + ". " + order.toString());
                                j++;
                            }
                        }
                    } catch (Exception e) {
                        System.out.println("暂无数据");
                    }
                    System.out.println("0. 返回订单处理");
                    int orderChoice = Input.getInt("请选择订单查看详情：");
                    if (orderChoice != 0) {
//                        orders.get(orderChoice-1).toTable();
                        System.out.println("按任意键返回");
                        scanner.nextLine();
                    } else {
                        break;
                    }
                }
                break;

            default:
                System.out.println("无效选择！");
                break;
        }
    }
}
