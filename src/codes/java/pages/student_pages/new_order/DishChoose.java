package codes.java.pages.student_pages.new_order;

import codes.java.entities.Dish;
import codes.java.entities.users.Merchant;
import codes.java.services.OrderService;
import codes.java.utils.CSVReader;
import codes.java.utils.Input;

import java.util.List;

public class DishChoose {
    Input input = new Input();
    OrderService orderService = new OrderService();
    List<Dish> dishList;
    Dish dishChosen;

    public Dish chooseDish(Merchant merchant) {

        System.out.println("\n=== 新建订单 ===");
        dishList = CSVReader.readDishesByMerchantID(merchant.getUserId());
        for (int i = 0; i < dishList.size(); i++) {
            System.out.println((i + 1) + ". " + dishList.get(i).getDishName());
        }
        System.out.println("0. 重新选择商家");
        int choice = input.getInt("请选择菜品：");

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
