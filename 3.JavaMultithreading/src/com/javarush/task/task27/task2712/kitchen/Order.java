package com.javarush.task.task27.task2712.kitchen;

import com.javarush.task.task27.task2712.ConsoleHelper;
import com.javarush.task.task27.task2712.Tablet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Order {
    private  final Tablet tablet;
    protected List<Dish> dishes;

    public Order(Tablet tablet) throws IOException {
        this.tablet = tablet;
        initDishes();
    }

    public Tablet getTablet() {
        return tablet;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Your order: [");
        for (Dish d : dishes) {
            sb.append(d.toString() + ", ");
        }
        sb = new StringBuilder(sb.substring(0, sb.length()-2));
        sb.append("] of " + tablet.toString());
        return sb.toString();
    }

    public List<Dish> getDishes() {
        return dishes;
    }

    public int getTotalCookingTime(){
        int totalCookingTime = 0;
        for (Dish dish: dishes) {
            totalCookingTime+=dish.getDuration();
        }
        return totalCookingTime;
    }

    public boolean isEmpty(){
        return dishes.isEmpty();
    }

    protected void initDishes() throws IOException {
        dishes = ConsoleHelper.getAllDishesForOrder();
    }
}
