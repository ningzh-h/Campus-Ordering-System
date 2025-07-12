package main.java.pages.merchant_pages.dishes_manager;

import main.java.entities.Dish;
import main.java.entities.users.Merchant;
import main.java.utils.ForCSV.CSVReader;
import main.java.utils.ForCSV.CSVUpdater;
import main.java.utils.Input;

import java.util.List;

public class DeleteDish {

    public void deleteDish(Merchant currentUser) {
        List<Dish> dishes = CSVReader.readDishesByMerchantID(currentUser.getUserID());
        try {
            DisplayDishes.displayDishes(dishes);
            int dishChoice = Input.getInt("请选择要删除的菜品序号：");
            if (dishChoice != 0 && dishChoice <= dishes.size()) {
                CSVUpdater.delete(dishes.get(dishChoice - 1));
            }
        } catch (Exception e) {
            System.out.println("暂无数据");
        }
    }
}
