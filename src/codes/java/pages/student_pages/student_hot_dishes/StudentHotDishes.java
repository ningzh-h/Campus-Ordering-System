package codes.java.pages.student_pages.student_hot_dishes;

import codes.java.entities.Dish;
import codes.java.entities.users.Student;
import codes.java.services.UserService;

import java.util.List;
import java.util.Scanner;

public class StudentHotDishes {
    Scanner scanner = new Scanner(System.in);
    UserService userService = new UserService();
    List<Dish> hotList=null;

    public void hotDishes(Student currentUser) {
        System.out.println("=== 热销排行榜 ===");
        try {
            // TODO: userService 按菜品被点次数顺序返回菜品列表
            // hotList = userService.getDishesByHot(currentUser.getUserId());
            int len = hotList.size();
            for (int i = 0; i < len; i++) {
                System.out.println((i+1) + ". " + hotList.get(i).toString());
            }
        } catch (Exception e) {
            System.out.println("暂无数据");
        }
        
        System.out.println("按回车键返回订餐系统");
        scanner.nextLine();
    }
}
