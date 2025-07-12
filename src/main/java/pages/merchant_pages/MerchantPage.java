package main.java.pages.merchant_pages;

import main.java.entities.users.Merchant;
import main.java.entities.users.User;
import main.java.pages.merchant_pages.dishes_manager.DishesManager;
import main.java.pages.merchant_pages.merchant_info.MerchantInfo;
import main.java.utils.Input;

import java.io.IOException;

public class MerchantPage {
    Merchant currentUser;
    DishesManager dishesManager = new DishesManager();
    OrdersManager ordersManager = new OrdersManager();
    SalesAnalyzer salesAnalyzer = new SalesAnalyzer();
    MerchantInfo merchantInfo = new MerchantInfo();

    // 商家页面
    public User showMerchantMenu(User currentUser) throws IOException {
        this.currentUser = (Merchant) currentUser;

        System.out.println("=== 商家管理系统 ===");
        System.out.println("1. 菜品管理");
        System.out.println("2. 订单处理");
        System.out.println("3. 销售分析");
        System.out.println("4. 商家信息");
        System.out.println("0. 退出登录");
        int choice = Input.getInt("请选择：");

        switch (choice) {
            case 0:
                this.currentUser = null;
                break;
            case 1:
                dishesManager.dishesManager(this.currentUser);
                break;
            case 2:
                ordersManager.ordersManager(this.currentUser);
                break;
            case 3:
                salesAnalyzer.salesAnalyzer(this.currentUser);
                break;
            case 4:
                merchantInfo.merchantInfo(this.currentUser);
                break;
            default:
                System.out.println("无效选择，请重新输入！");
                break;
        }
        return this.currentUser;
    }
}
