package main.java.pages.student_pages.new_order;

import main.java.entities.Dish;
import main.java.entities.users.Merchant;
import main.java.utils.Input;

import java.util.List;

public class DishChoose {
    List<Dish> dishList;
    Dish dishChosen;

    public Dish chooseDish(Merchant merchant) {

        System.out.println("\n=== 新建订单 ===");
        // TODO: Merchant 的 getDishList() 方法, 返回商家菜品列表
//        dishList = merchant.getDishList();
        int len = dishList.size();
        for (int i = 0; i < len; i++) {
            System.out.println((i+1) + ". " + dishList.get(i));
        }
        System.out.println("0. 重新选择商家");
        int choice = Input.getInt("请选择菜品：");

        try {
            if (choice == 0) {
                dishChosen = null;
            } else {
                dishChosen = dishList.get(choice-1);
            }
        } catch (Exception e) {
            System.out.println("无效选择！");
            dishChosen = null;
        }
        return dishChosen;
    }
}
