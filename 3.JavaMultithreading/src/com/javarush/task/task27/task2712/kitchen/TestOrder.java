package com.javarush.task.task27.task2712.kitchen;

import com.javarush.task.task27.task2712.Tablet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TestOrder extends Order {
    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    protected void initDishes() {
        int random = (int) (Math.random()*Dish.values().length);
        dishes = new ArrayList<>();
        for (int i = 0; i <= random; i++) {
            random = (int) (Math.random()*Dish.values().length);
            dishes.add(Dish.values()[random]);
        }
    }

    @Override
    public List<Dish> getDishes() {
        return super.getDishes();
    }

    public TestOrder(Tablet tablet) throws IOException {
        super(tablet);
    }

    @Override
    public int getTotalCookingTime() {
        return super.getTotalCookingTime();
    }

    @Override
    public boolean isEmpty() {
        return super.isEmpty();
    }
}
