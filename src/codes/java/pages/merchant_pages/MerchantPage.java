package codes.java.pages.merchant_pages;

import codes.java.entities.users.Merchant;
import codes.java.entities.users.User;
import codes.java.utils.Input;

public class MerchantPage {
    Merchant currentUser;
    Input input = new Input();
    DishesManager dishesManager = new DishesManager();
    OrdersManager ordersManager = new OrdersManager();
    SalesAnalyzer salesAnalyzer = new SalesAnalyzer();

    // 商家页面
    public User showMerchantMenu(User currentUser) {
        this.currentUser = (Merchant) currentUser;

        System.out.println("=== 商家管理系统 ===");
        System.out.println("1. 菜品管理");
        System.out.println("2. 订单处理");
        System.out.println("3. 销售分析");
        System.out.println("4. 商家信息");
        System.out.println("0. 退出登录");
        int choice = input.getInt("请选择：");

        switch (choice) {
            case 0:
                this.currentUser = null;
                break;
            case 1:
                dishesManager.dishesManager(this.currentUser);
            case 2:
                ordersManager.ordersManager(this.currentUser);
            case 3:
                salesAnalyzer.salesAnalyzer(this.currentUser);
            case 4:
                // TODO: 应该在 User 里写一个方法 editInfo() 来实现比较好
//                currentUser.editInfo();
            default:
                System.out.println("无效选择，请重新输入！");
        }
        return currentUser;
    }
}
