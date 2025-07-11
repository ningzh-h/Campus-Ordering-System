package main.java.pages.student_pages.new_order;

import main.java.entities.Dish;
import main.java.entities.users.Merchant;
import main.java.entities.users.Student;
import main.java.utils.Input;

public class NewOrder {
    CanteenChoose canteenChoose = new CanteenChoose();
    String canteen;
    MerchantChoose merchantChoose = new MerchantChoose();
    Merchant merchant;
    DishChoose dishChoose = new DishChoose();
    Dish dish;
    int quantity = 0;

    public void newOrder(Student currentUser) {
        canteen = canteenChoose.chooseCanteen();
        if (!canteen.equals("R")) {
            while (true) {
                merchant = merchantChoose.chooseMerchant(canteen);
                if(merchant != null) {
                    dish = dishChoose.chooseDish(merchant);
                    if (dish != null) {
                        System.out.println("您的选择是："
                                + merchant.getAddress()
                                + merchant.getMerchantName() + "的"
                                + dish.getDishName()
                        );
                        quantity = Input.getInt("请输入订餐数量：");

                        System.out.println("正在为您生成订单...");
                        // TODO: 创建新的Order, 并写入订单查询 csv 中, 应该加上 OrderService
//                        Order order = new Order();
                        System.out.println("已为您生成订单！");

                        System.out.println("订单信息：");
                        // TODO: Order 的 toTable 方法
//                        order.toTable();
                        return;
                    }
                } else {
                    break;
                }
            }
        }
    }
}
