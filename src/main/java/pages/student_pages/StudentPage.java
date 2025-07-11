package main.java.pages.student_pages;

import main.java.entities.users.Student;
import main.java.entities.users.User;
import main.java.pages.student_pages.my_orders.MyOrders;
import main.java.pages.student_pages.new_order.NewOrder;
import main.java.pages.student_pages.student_popular_dishes.StudentPopularDishes;
import main.java.pages.student_pages.student_info.StudentInfo;
import main.java.utils.Input;


public class StudentPage {
    Student currentUser = null;
    NewOrder newOrder = new NewOrder();
    MyOrders myOrders = new MyOrders();
    StudentPopularDishes popularDishes = new StudentPopularDishes();
    StudentInfo studentInfo = new StudentInfo();

    // 学生页面
    public User showStudentMenu(User currentUser) {
        this.currentUser = (Student) currentUser;

        System.out.println("\n=== 学生订餐系统 ===");
        System.out.println("1. 新建订单");
        System.out.println("2. 我的订单");
        System.out.println("3. 热销菜品");
        System.out.println("4. 个人信息");
        System.out.println("0. 退出登录");

        int choice = Input.getInt("请选择：");
        switch (choice) {
            case 0:
                this.currentUser = null;
                System.out.println("已退出登录，欢迎下次使用。");
                break;
            case 1:
                newOrder.newOrder(this.currentUser);
                break;
            case 2:
                myOrders.myOrders(this.currentUser);
                break;
           case 3:
                popularDishes.popularDishes(this.currentUser);
                break;
           case 4:
                studentInfo.studentInfo(this.currentUser);
                break;
            default:
                System.out.println("无效选择，请重新输入！");
        }
        return this.currentUser;
    }
}