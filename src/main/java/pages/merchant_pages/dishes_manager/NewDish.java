package main.java.pages.merchant_pages.dishes_manager;

import main.java.entities.Dish;
import main.java.entities.users.Merchant;
import main.java.services.DishService;
import main.java.utils.Input;


public class NewDish {
    DishService dishService = new DishService();

    public void newDish(Merchant currentUser) {

        try {
            String dishName = Input.getString("请输入菜品名称：");
            double dishPrice = Input.getDouble("请输入菜品价格：");
            int merchantID = currentUser.getUserID();
            int stock = Input.getInt("请输入菜品余量：");

            Dish newDish = new Dish(
                dishName,
                dishPrice,
                merchantID,
                stock,
                0
            );
            dishService.createDish(newDish);
            System.out.println("菜品信息：");
            System.out.println(newDish);
        } catch (Exception e) {
            System.out.println("暂无数据");
        }
    }
}
