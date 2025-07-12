package main.java.pages.merchant_pages.merchant_info;

import main.java.entities.users.Merchant;
import main.java.utils.Input;

public class MerchantInfo {
    EditMerchantInfo editMerchantInfo = new EditMerchantInfo();

    public void merchantInfo(Merchant currentUser) {
        System.out.println("=== 商家信息 ===");
        System.out.println("1. 用户名：" + currentUser.getUsername());
        System.out.println("2. 用户ID：" + currentUser.getUserID());
        System.out.println("3. 密码设置");
        System.out.println("4. 电话：" + currentUser.getPhone());
        System.out.println("5. 地址：" + currentUser.getAddress());
        System.out.println("0. 返回订餐系统");
        int choice = Input.getInt("请选择：");

        editMerchantInfo.editInfo(currentUser, choice);
    }
}
