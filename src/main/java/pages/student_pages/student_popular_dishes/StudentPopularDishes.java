package main.java.pages.student_pages.student_popular_dishes;

import main.java.entities.Dish;
import main.java.entities.users.Merchant;
import main.java.entities.users.Student;
import main.java.services.DishService;
import main.java.utils.ForCSV.CSVReader;
import main.java.utils.Input;

import java.util.List;

public class StudentPopularDishes {
    DishService dishService = new DishService();

    public void popularDishes() {
        Merchant merchant;
        System.out.println("=== 热销排行榜 ===");
        try {
            List<Dish> popularDishes = dishService.getPopularDishes();
            int len = popularDishes.size();
            for (int i = 0; i < len; i++) {
                merchant = (Merchant) CSVReader.readUserByUserID(popularDishes.get(i).getMerchantID());
                if (merchant != null) {
                    System.out.println((i+1) + ". " + popularDishes.get(i).toString() + "，热度：" + popularDishes.get(i).getPopularity() + "，位于" + merchant.getAddress() + "的" + merchant.getUsername());
                }
            }
        } catch (Exception e) {
            System.out.println("暂无数据");
        }
        
        Input.jump("按回车键返回订餐系统");
    }
}
