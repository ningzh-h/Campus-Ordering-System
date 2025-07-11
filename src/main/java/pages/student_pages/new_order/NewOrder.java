package main.java.pages.student_pages.new_order;

import main.java.entities.Dish;
import main.java.entities.Order;
import main.java.entities.users.Merchant;
import main.java.entities.users.Student;
import main.java.utils.Input;

import static java.time.LocalDateTime.now;

public class NewOrder {
    CanteenChoose canteenChoose = new CanteenChoose();
    int canteen;
    MerchantChoose merchantChoose = new MerchantChoose();
    Merchant merchant;
    DishChoose dishChoose = new DishChoose();
    Dish dish;
    int quantity = 0;

    public void newOrder(Student currentUser) {
        canteen = canteenChoose.chooseCanteen();
        if (canteen != 0) {
            while (true) {
                merchant = merchantChoose.chooseMerchant(canteen);
                if(merchant != null) {
                    dish = dishChoose.chooseDish(merchant);
                    if (dish != null) {
                        System.out.println("您的选择是："
                                + merchant.getAddress()
                                + merchant.getUsername() + "的"
                                + dish.getDishName()
                        );
                        quantity = Input.getInt("请输入订餐数量：");

                        System.out.println("正在为您生成订单...");
                        Order order = new Order(
                            currentUser,
                            merchant,
                            dish,
                            quantity,
                            now(),
                            dish.getPrice() * quantity,
                            1
                        );
                        System.out.println("已为您生成订单！");
                        System.out.println("订单信息：");
                        System.out.println(order);
                        return;
                    }
                } else {
                    break;
                }
            }
        }
    }
}
