package main.java.pages.merchant_pages.sales_analyzer;

import main.java.entities.users.User;
import main.java.services.UserService;

import java.io.IOException;

public class SalesAnalyzer {
    static UserService userService = new UserService();

    public void salesAnalyzer(User currentUser) {
        try {
            userService.merchantSalesAnalyze(currentUser);
        } catch (IOException e) {
            System.err.println("商家数据分析失败！");
        }
    }
}
