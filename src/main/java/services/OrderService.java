package main.java.services;

import main.java.entities.Dish;
import main.java.entities.Order;
import main.java.utils.CSVReader;
import main.java.utils.CSVUpdater;
import main.java.utils.CSVWriter;
import main.java.utils.Input;

import java.util.List;

public class OrderService {

    public boolean createOrder(Order order) {
        List<Integer> orderIDs = CSVReader.readIDs("orders");

        if (orderIDs.isEmpty()) {
            order.setOrderID(1);
        } else {
            int maxOrderID = orderIDs.stream().max(Integer::compareTo).orElse(0);
            order.setOrderID(maxOrderID + 1);
        }
        Dish dish = order.getDish();

        if (dish.getStock() < order.getQuantity()) {
            System.out.println("库存不足，无法完成订单！");
            Input.jump("按回车键返回");
            return false;
        }

        dish.setPopularity(dish.getPopularity() + order.getQuantity());      // +餐品热度
        dish.setStock(dish.getStock() - order.getQuantity());                // -餐品库存

        CSVWriter.write(order);
        CSVUpdater.update(dish);
        Input.jump("按回车键提交订单");
        return true;
    }

    public void cancelOrder(Order order) {
        Dish dish = order.getDish();
        dish.setPopularity(dish.getPopularity() - order.getQuantity());
        dish.setStock(dish.getStock() + order.getQuantity());
        CSVUpdater.update(dish);
        CSVUpdater.updateOrderStatus(order.getOrderID(), 2); // 将订单状态更新为已取消
        System.out.println("订单已取消！");
    }

    public static List<Order> getCurrentOrders(List<Order> orders) {
        //根据订单状态筛选出当前订单，status为1表示下单成功，但商家还未完成
        return orders.stream()
                .filter(order -> order.getStatus() == 1)
                .toList();
    }

    public static List<Order> getHistoryOrders(List<Order> orders) {
        //根据订单状态筛选出历史订单，包括取消和完成的
        return orders.stream()
                .filter(order -> order.getStatus() != 1)
                .toList();
    }

    public static void finishOrder(Order order) {
        // 将订单状态更新为已完成
        CSVUpdater.updateOrderStatus(order.getOrderID(), 3);
        System.out.println("订单已完成！");
        Input.jump("按回车键返回");
    }
}
