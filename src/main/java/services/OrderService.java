package main.java.services;

import main.java.entities.Dish;
import main.java.entities.Order;
import main.java.utils.CSVReader;
import main.java.utils.CSVUpdater;
import main.java.utils.CSVWriter;
import main.java.utils.Input;

import java.util.List;

public class OrderService {

    public void createOrder(Order order) {
        List<Integer> orderIDs = CSVReader.readIDs("orders");

        if (orderIDs.isEmpty()) {
            order.setOrderID(1);
        } else {
            int maxOrderID = orderIDs.stream().max(Integer::compareTo).orElse(0);
            order.setOrderID(maxOrderID + 1);
        }
        Dish dish = order.getDish();
        dish.setPopularity(order.getQuantity());

        CSVWriter.write(order);
        CSVUpdater.update(dish);
        Input.jump("按回车键提交订单");
    }

    public void cancelOrder(Order order) {
        CSVUpdater.updateOrderStatus(order.getOrderID());
        System.out.println("订单已取消！");
    }
}
