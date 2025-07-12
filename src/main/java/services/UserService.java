package main.java.services;

import main.java.entities.Order;
import main.java.entities.users.User;
import main.java.utils.ForCSV.CSVReader;
import main.java.utils.ForPython.ExecPython;

import java.io.IOException;
import java.util.List;

public class UserService {

    public List<Order> getOrdersByUser(User user) {
        return CSVReader.readOrdersByUserID(user.getUserID(), user.getRole());
    }

    public void merchantSalesAnalyze(User user) throws IOException {
        ExecPython.execPython("src/main/python/data_analyzer/for_merchants/sales_analyzer.py", user.getUserID());
    }
}
