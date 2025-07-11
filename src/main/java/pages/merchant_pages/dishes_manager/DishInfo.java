package main.java.pages.merchant_pages.dishes_manager;

import main.java.entities.Dish;
import main.java.entities.users.Merchant;
import main.java.utils.CSVReader;
import main.java.utils.Input;

import java.util.List;

public class DishInfo {

    public void dishInfo(Merchant currentUser) {
        List<Dish> dishes = CSVReader.readDishesByMerchantID(currentUser.getUserID());
        EditDishInfo editDishInfo = new EditDishInfo();

        while (true) {
            try {
                DisplayDishes.displayDishes(dishes);
                int dishChoice = Input.getInt("请选择要修改的菜品序号：");
                Dish dish = dishes.get(dishChoice - 1);

                System.out.println("\n=== 菜品信息 ===");
                System.out.println("1. 菜品名称：" + dish.getDishName());
                System.out.println("2. 菜品ID：" + dish.getDishID());
                System.out.println("3. 菜品价格：" + dish.getPrice());
                System.out.println("4. 菜品余量：" + dish.getStock());
                System.out.println("5. 菜品热度：" + dish.getPopularity());
                System.out.println("0. 返回菜品选择");
                int choice = Input.getInt("请选择：");

                editDishInfo.editDishInfo(dish, choice);

            } catch (Exception e) {
                System.out.println("暂无数据");
                return;
            }
        }
    }
}
