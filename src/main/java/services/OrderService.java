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

        dish.setPopularity(order.getQuantity());              // +餐品热度
        dish.setStock(dish.getStock() - order.getQuantity()); // -餐品库存

        CSVWriter.write(order);
        CSVUpdater.update(dish);
        Input.jump("按回车键提交订单");
        return true;
    }

    public void cancelOrder(Order order) {
        CSVUpdater.updateOrderStatus(order.getOrderID());
        System.out.println("订单已取消！");
    }
}
