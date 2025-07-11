package codes.java.pages.student_pages.new_order;


import codes.java.utils.Input;

public class CanteenChoose {
    Input input = new Input();
    int canteen;

    public int chooseCanteen() {
        System.out.println("\n=== 新建订单 ===");
        System.out.println("1. 一食堂");
        System.out.println("2. 二食堂");
        System.out.println("3. 三食堂");
        System.out.println("4. 四食堂");
        System.out.println("0. 返回订餐系统");

        int choice = input.getInt("请选择订餐食堂：");

        switch (choice) {
            case 0:
                return 0;
            case 1:
                canteen = 1;
                break;
            case 2:
                canteen = 2;
                break;
            case 3:
                canteen = 3;
                break;
            case 4:
                canteen = 4;
                break;
            default:
                System.out.println("无效选择！");
                break;
        }
        return canteen;
    }

}

