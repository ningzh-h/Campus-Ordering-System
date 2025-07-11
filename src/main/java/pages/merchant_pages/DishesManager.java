package main.java.pages.merchant_pages;

import main.java.entities.Dish;
import main.java.entities.users.Merchant;
import main.java.utils.Input;

import java.util.List;

public class DishesManager {
    List<Dish> dishes;

    public void dishesManager(Merchant currentUser) {
        // TODO: dishes 来自商家类 Merchant
//        dishes = currentUser.getDishes();
        System.out.println("=== 菜品管理 ===");
        System.out.println("1. 新增菜品");
        System.out.println("2. 删除菜品");
        System.out.println("3. 修改信息");
        System.out.println("0. 返回管理系统");
        int choice = Input.getInt("请选择：");

        switch (choice) {
            case 0:
                break;
            case 1:
                try {
                    // TODO: new 一个 Dish
                    Dish newDish = null;
                    dishes.add(newDish);
                    // TODO: dishes 来自商家类 Merchant
                    //                currentUser.setDishes(dishes);
                } catch (Exception e) {
                    System.out.println("暂无数据");
                }
                break;

            case 2:
                try {
                    int len = dishes.size();
                    for (int i = 0; i < len; i++) {
                        System.out.println((i + 1) + ". " + dishes.get(i).toString());
                    }
                    int dishChoice = Input.getInt("请选择要删除的菜品序号：");
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
                    int dishChoice = Input.getInt("请选择要修改的菜品序号：");
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
