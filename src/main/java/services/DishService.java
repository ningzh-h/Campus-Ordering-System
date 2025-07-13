package main.java.services;

import main.java.entities.Dish;
import main.java.utils.ForCSV.CSVReader;
import main.java.utils.ForCSV.CSVWriter;
import main.java.utils.ForPython.ExecPython;
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

    public List<Dish> getPopularDishes() {
        ExecPython.execPython("src/main/python/data_analyzer/for_students/popular_dishes.py");
        return CSVReader.readTOP10Dishes();
    }
}
