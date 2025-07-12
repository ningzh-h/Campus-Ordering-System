package main.java.services;

import main.java.entities.Dish;
import main.java.utils.CSVReader;
import main.java.utils.CSVWriter;
import main.java.utils.Input;

import java.util.List;

public class DishService {

    public void createDish(Dish dish) {
        List<Integer> dishIDs = CSVReader.readIDs("dishes");

        if (dishIDs.isEmpty()) {
            dish.setDishID(1);
        } else {
            int maxDishID = dishIDs.stream().max(Integer::compareTo).orElse(0);
            dish.setDishID(maxDishID + 1);
        }

        CSVWriter.write(dish);
        System.out.println("新增菜品成功！");
        Input.jump("按回车键提交");
    }
}
