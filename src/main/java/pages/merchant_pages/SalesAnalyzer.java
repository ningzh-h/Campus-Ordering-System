package main.java.pages.merchant_pages;

import main.java.entities.users.User;
import main.java.services.UserService;

import java.io.IOException;

public class SalesAnalyzer {
    static UserService userService = new UserService();

    public void salesAnalyzer(User currentUser) {
        try {
            userService.merchantSalesAnalyze(currentUser);
            System.out.println("已存储商家数据分析可视化结果到 resources/python/for_merchants/img 中");
        } catch (IOException e) {
            System.err.println("商家数据分析失败！");
        }
    }
}
