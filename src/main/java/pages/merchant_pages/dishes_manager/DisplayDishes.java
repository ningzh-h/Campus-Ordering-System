package main.java.pages.merchant_pages.dishes_manager;

import main.java.entities.Dish;

import java.util.List;

public class DisplayDishes {
    public static void displayDishes(List<Dish> dishes) {
        int len = dishes.size();
        for (int i = 0; i < len; i++) {
            System.out.println((i + 1) + ". " + dishes.get(i).toString());
        }
        System.out.println("0. 返回菜品管理");
    }
}
