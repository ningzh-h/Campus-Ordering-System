package codes.java.services;

import codes.java.entities.Order;
import codes.java.utils.CSVGenerate;
import codes.java.utils.CSVReader;

import java.util.List;

public class OrderService {

    public static void createOrder(Order order) {
        List<Integer> orderIDs = CSVReader.readIDs("orders");

        if (orderIDs.isEmpty()) {
            order.setOrderID(1);  // 如果订单列表为空，则ID从1开始设置
        } else {
            // 获取当前最大订单ID，并设置新订单ID为最大ID加1
            int maxOrderID = orderIDs.stream().max(Integer::compareTo).orElse(0);
            order.setOrderID(maxOrderID + 1);
        }

        CSVGenerate.writeOrder(order);
        System.out.println("提交订单");
    }
}
