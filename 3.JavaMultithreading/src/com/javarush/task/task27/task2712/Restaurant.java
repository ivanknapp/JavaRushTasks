package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.kitchen.Cook;
import com.javarush.task.task27.task2712.kitchen.Order;
import com.javarush.task.task27.task2712.kitchen.Waiter;
import com.javarush.task.task27.task2712.statistic.StatisticManager;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;

public class Restaurant {
    private static final int ORDER_CREATING_INTERVAL = 100;
    private final static LinkedBlockingQueue<Order> orderQueue = new LinkedBlockingQueue<>();

    public static void main(String[] args) throws InterruptedException {

        Cook petrov = new Cook("Petrov");
        Cook ivanov = new Cook("Ivanov");

        petrov.setQueue(orderQueue);
        ivanov.setQueue(orderQueue);

        StatisticManager statisticManager = StatisticManager.getInstance();

        List<Tablet> tablets = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Tablet tablet = new Tablet(i+1);
            tablet.setQueue(orderQueue);
            tablets.add(tablet);

        }
        Waiter waitor = new Waiter();

        petrov.addObserver(waitor);
        ivanov.addObserver(waitor);

        Thread threadPetrov = new Thread(petrov);
        Thread threadIvanov = new Thread(ivanov);

        threadPetrov.start();
        threadIvanov.start();



        RandomOrderGeneratorTask generatorTask = new RandomOrderGeneratorTask(tablets, ORDER_CREATING_INTERVAL);

        Thread thread = new Thread(generatorTask);


        thread.start();

        Thread.sleep(1000);

        thread.interrupt();



        System.out.println("*************************************************");
        DirectorTablet directorTablet = new DirectorTablet();
        System.out.println("*************ADS PROFIT**************************");
        directorTablet.printAdvertisementProfit();
        System.out.println("*************COOK WORKLOADING********************");
        directorTablet.printCookWorkloading();
        System.out.println("*************ACTIVE VIDEO************************");
        directorTablet.printActiveVideoSet();
        System.out.println("*************ARCHIVE VIDEO***********************");
        directorTablet.printArchivedVideoSet();//

    }
}