package codes.java.pages.student_pages.new_order;

import codes.java.entities.Dish;
import codes.java.entities.Order;
import codes.java.entities.users.Merchant;
import codes.java.entities.users.Student;
import codes.java.services.OrderService;
import codes.java.utils.CSVGenerate;
import codes.java.utils.Input;
import static java.time.LocalDateTime.now;

public class NewOrder {
    Input input = new Input();
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
                                + merchant.getMerchantName() + "的"
                                + dish.getDishName()
                        );
                        quantity = input.getInt("请输入订餐数量：");

                        System.out.println("正在为您生成订单...");
                        Order order = new Order(currentUser, merchant, now(), dish, quantity, dish.getPrice() * quantity, 1, currentUser.getAddress(), currentUser.getPhone());
                        OrderService.createOrder(order);
                        System.out.println("已为您生成订单！");
                        System.out.println("订单信息：\n" + order);
                        return;
                    }
                } else {
                    break;
                }
            }
        }
    }
}
