package main.java.services;

import main.java.entities.Dish;
import main.java.entities.Order;
import main.java.utils.CSVReader;
import main.java.utils.CSVUpdater;
import main.java.utils.CSVWriter;

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
        dish.updatePopularity();

        CSVWriter.writeOrder(order);
        CSVUpdater.update(dish);
        System.out.println("提交订单");
    }


}
