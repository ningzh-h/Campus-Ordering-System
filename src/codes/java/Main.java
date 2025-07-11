package codes.java;

import codes.java.entities.Order;
import codes.java.entities.users.Merchant;
import codes.java.entities.users.Student;
import codes.java.entities.users.User;
import codes.java.pages.login_pages.LoginPage;
import codes.java.pages.merchant_pages.MerchantPage;
import codes.java.pages.student_pages.StudentPage;
import codes.java.utils.CSVGenerate;
import codes.java.utils.CSVReader;

import java.util.List;


public class Main {
    private static final LoginPage loginPage = new LoginPage();
    private static final StudentPage studentPage = new StudentPage();
    private static final MerchantPage merchantPage = new MerchantPage();
    private static User currentUser = null;

    public static void main(String[] args) {
        System.out.println("欢迎使用校园餐厅订餐系统！");

        // 流程控制
        while (true) {
            if (currentUser == null) {
               currentUser = loginPage.showLoginPage();
            } else {
                if (currentUser.getRole() == 0) {
                    currentUser = studentPage.showStudentMenu(currentUser);
                } else if (currentUser.getRole() == 1) {
                    currentUser = merchantPage.showMerchantMenu(currentUser);
                } else {
                    System.out.println("账号登录异常，请重新登录。");
                    currentUser = null;
                }
            }
        }
    }
}
