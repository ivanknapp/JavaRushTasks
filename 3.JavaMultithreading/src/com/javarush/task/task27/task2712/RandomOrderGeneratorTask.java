package com.javarush.task.task27.task2712;

import java.util.ArrayList;
import java.util.List;

public class RandomOrderGeneratorTask implements Runnable {
    private List<Tablet> tabletList;
    private int ORDER_CREATING_INTERVAL;

    public RandomOrderGeneratorTask(List<Tablet> tablets, int interval) {
        this.tabletList = tablets;
        this.ORDER_CREATING_INTERVAL = interval;
    }

    @Override
    public void run() {
        Tablet tablet;

        while (!Thread.currentThread().isInterrupted()) {
            tablet = tabletList.get((int) (Math.random() * tabletList.size()));
            tablet.createTestOrder();
            try {
                Thread.sleep(ORDER_CREATING_INTERVAL);
            } catch (InterruptedException e) {
                break;
            }
        }
    }
}
