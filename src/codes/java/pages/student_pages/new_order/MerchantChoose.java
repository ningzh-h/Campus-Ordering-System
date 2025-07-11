package codes.java.pages.student_pages.new_order;

import codes.java.entities.users.Merchant;
import codes.java.services.OrderService;
import codes.java.utils.CSVReader;
import codes.java.utils.Input;

import java.util.List;

public class MerchantChoose {
    Input input = new Input();
    Merchant merchantChosen;
    List<Merchant> merchantList;
    OrderService orderService = new OrderService();

    public Merchant chooseMerchant(int canteen) {
        System.out.println("\n=== 新建订单 ===");

        merchantList = CSVReader.readMerchantByCanteen(canteen);
        for (int i = 0; i < merchantList.size(); i++) {
           System.out.println((i + 1) + ". " + merchantList.get(i).getMerchantName());
        }

        System.out.println("0. 重新选择食堂");
        int choice = input.getInt("请选择商家：");

        try {
            if (choice == 0) {
                merchantChosen = null;
            } else {
                merchantChosen = merchantList.get(choice - 1);
            }
        } catch (Exception e) {
            System.out.println("无效选择！");
            merchantChosen = null;
        }
        return merchantChosen;
    }
}
