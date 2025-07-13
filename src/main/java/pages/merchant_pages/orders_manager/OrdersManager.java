package main.java.pages.merchant_pages.orders_manager;

import main.java.entities.Order;
import main.java.entities.users.Merchant;
import main.java.services.OrderService;
import main.java.services.UserService;
import main.java.utils.Input;

import java.util.List;

public class OrdersManager {
    UserService userService = new UserService();
    List<Order> orders;

    public void ordersManager(Merchant currentUser) {
        // 获取当前商家的所有订单，包括待处理的当前订单和历史订单
        orders = userService.getOrdersByUser(currentUser);

        // 根据订单状态分离当前订单和历史订单
        List<Order> currentOrders = OrderService.getCurrentOrders(orders);
        List<Order> historyOrders = OrderService.getHistoryOrders(orders);

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
                    int j = 0;
                    for (Order order : currentOrders) {
                        try {
                            System.out.println((j + 1) + ". " + order.toString());
                        } catch (Exception e) {
                            System.out.println("订单 " + (j + 1) + " 已经被删除或不存在");
                        } finally {
                            System.out.println("------------------------------");
                            j++;
                        }
                    }

                    System.out.println("0. 返回订单处理");
                    int orderChoice = Input.getInt("请选择要交付的订单序号：");
                    if (orderChoice != 0) {
                        OrderService.finishOrder(currentOrders.get(orderChoice - 1));
                    }
                    break;
                }
                break;
            case 2:
                while (true) {
                    try {
                        int j = 0;
                        for (Order order : historyOrders) {
                            try {
                                System.out.println((j + 1) + ". " + order.toString());
                            } catch (Exception e) {
                                System.out.println("订单 " + (j + 1) + " 已经被删除或不存在");
                            } finally {
                                System.out.println("------------------------------");
                                j++;
                            }
                        }
                    } catch (Exception e) {
                        System.out.println("暂无数据");
                    }
                    Input.jump("按回车键返回");
                    break;
                }
                break;

            default:
                System.out.println("无效选择！");
                break;
        }
    }
}
