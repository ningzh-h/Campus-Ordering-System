package main.java.services;

import main.java.entities.Order;
import main.java.entities.users.User;
import main.java.utils.CSVReader;

import java.util.List;

public class UserService {

    public void editInfo(User currentUser) {

    }

    public List<Order> getOrdersByUser(User user) {
        return CSVReader.readOrdersByUserID(user.getUserID(), user.getRole());
    }
}
