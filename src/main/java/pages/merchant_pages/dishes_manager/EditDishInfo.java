package main.java.pages.merchant_pages.dishes_manager;

import main.java.entities.Dish;
import main.java.utils.ForCSV.CSVUpdater;
import main.java.utils.Input;

public class EditDishInfo {

    public void editDishInfo(Dish dish, int choice) {
        int editChoice;
        switch (choice) {
            case 0:
                break;

            case 1:
                System.out.println("菜品名：" + dish.getDishName());
                System.out.println("1. 修改信息");
                System.out.println("0. 返回菜品信息");
                editChoice = Input.getInt("请选择：");
                switch (editChoice) {
                    case 0 -> {}
                    case 1 -> dish.setDishName(Input.getString("请输入新的菜品名："));
                    default -> System.out.println("无效选择");
                }
                break;

            case 3:
                System.out.println("菜品价格为：" + dish.getPrice());
                System.out.println("1. 修改信息");
                System.out.println("0. 返回菜品信息");
                editChoice = Input.getInt("请选择：");
                switch (editChoice) {
                    case 0 -> {}
                    case 1 -> dish.setPrice(Input.getDouble("请输入新的价格："));
                    default -> System.out.println("无效选择");
                }
                break;

            case 4:
                System.out.println("菜品剩余 " + dish.getStock() + " 份");
                System.out.println("1. 修改信息");
                System.out.println("0. 返回菜品信息");
                editChoice = Input.getInt("请选择：");
                switch (editChoice) {
                    case 0 -> {}
                    case 1 -> dish.setStock(Input.getInt("请输入新的余量："));
                    default -> System.out.println("无效选择");
                }
                break;


            default:
                System.out.println("无效选择！");
                break;
        }
        CSVUpdater.update(dish);
    }
}
