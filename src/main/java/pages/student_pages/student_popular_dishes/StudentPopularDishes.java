package main.java.pages.student_pages.student_popular_dishes;

import main.java.entities.Dish;
import main.java.entities.users.Student;
import main.java.services.OrderService;
import main.java.utils.Input;

import java.util.List;

public class StudentPopularDishes {
    OrderService orderService = new OrderService();
    List<Dish> hotList=null;

    public void popularDishes(Student currentUser) {
        System.out.println("=== 热销排行榜 ===");
        try {
            // TODO: orderService 按菜品被点次数顺序返回菜品列表
//             popularList = orderService.getDishesByPopularity(currentUser.getUserId());
            int len = hotList.size();
            for (int i = 0; i < len; i++) {
                System.out.println((i+1) + ". " + hotList.get(i).toString());
            }
        } catch (Exception e) {
            System.out.println("暂无数据");
        }
        
        Input.jump("按回车键返回订餐系统");
    }
}
