package codes.java.pages.merchant_pages.dishes_manager;

import codes.java.entities.Dish;
import codes.java.entities.users.Merchant;
import codes.java.utils.Input;

import java.util.List;

public class DishesManager {
    Input input = new Input();
    List<Dish> dishes;

    public void dishesManager(Merchant currentUser) {
        // TODO: dishes 来自商家类 Merchant
//        dishes = currentUser.getDishes();
        System.out.println("=== 菜品管理 ===");
        System.out.println("1. 新增菜品");
        System.out.println("2. 删除菜品");
        System.out.println("3. 修改信息");
        System.out.println("0. 返回管理系统");
        int choice = input.getInt("请选择：");

        switch (choice) {
            case 0:
                break;
            case 1:
                // TODO: new 一个 Dish
                Dish newDish = null;
                dishes.add(newDish);
                // TODO: dishes 来自商家类 Merchant
//                currentUser.setDishes(dishes);
                break;

            case 2:
                try {
                    int len = dishes.size();
                    for (int i = 0; i < len; i++) {
                        System.out.println((i + 1) + ". " + dishes.get(i).toString());
                    }
                    int dishChoice = input.getInt("请选择要删除的菜品序号：");
                    dishes.remove(dishChoice);
//                    currentUser.setDishes(dishes);
                } catch (Exception e) {
                    System.out.println("暂无数据");
                    return;
                }

            case 3:
                try {
                    int len = dishes.size();
                    for (int i = 0; i < len; i++) {
                        System.out.println((i + 1) + ". " + dishes.get(i).toString());
                    }
                    int dishChoice = input.getInt("请选择要修改的菜品序号：");
                    // TODO: 怎么修改菜品呢
                } catch (Exception e) {
                    System.out.println("暂无数据");
                    return;
                }

            default:
                System.out.println("无效选择！");
        }
    }
}
