package main.java.pages.merchant_pages.dishes_manager;

import main.java.entities.Dish;
import main.java.entities.users.Merchant;
import main.java.utils.ForCSV.CSVReader;
import main.java.utils.Input;

import java.util.List;

public class DishesManager {
    List<Dish> dishes;

    public void dishesManager(Merchant currentUser) {
        dishes = CSVReader.readDishesByMerchantID(currentUser.getUserID());
        NewDish newDish = new NewDish();
        DeleteDish deleteDish = new DeleteDish();
        DishInfo dishInfo = new DishInfo();

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
                newDish.newDish(currentUser);
                dishes = CSVReader.readDishesByMerchantID(currentUser.getUserID());
                break;

            case 2:
                deleteDish.deleteDish(currentUser);
                break;

            case 3:
                dishInfo.dishInfo(currentUser);
                break;

            default:
                System.out.println("无效选择！");
        }
    }
}
