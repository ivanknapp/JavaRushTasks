package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.ad.AdvertisementManager;
import com.javarush.task.task27.task2712.ad.NoVideoAvailableException;
import com.javarush.task.task27.task2712.kitchen.Order;
import com.javarush.task.task27.task2712.kitchen.TestOrder;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Tablet {
    final int number;
    private static java.util.logging.Logger logger = Logger.getLogger(Tablet.class.getName());
    private LinkedBlockingQueue<Order> queue = new LinkedBlockingQueue<>();

    public void setQueue(LinkedBlockingQueue<Order> orderQueue) {
        this.queue = orderQueue;
    }

    public Tablet(int number) {
        this.number = number;
    }

    public Order createOrder(){
        try {
            Order order = new Order(this);
            if (!order.isEmpty()) {
                initOrder(order);
                return order;
            }else {
                return null;
            }
        }catch (Exception e){
            e.printStackTrace();
            logger.log(Level.SEVERE, "Console is unavailable.");
            return null;
        }
    }

    public void createTestOrder(){
        try {
            TestOrder order = new TestOrder(this);

            initOrder(order);

        }catch (Exception e){
            e.printStackTrace();
            logger.log(Level.SEVERE, "Console is unavailable.");
        }
    }

    private void initOrder(Order order) {
        AdvertisementManager advertisementManager = new AdvertisementManager(order.getTotalCookingTime()*60);
        //ConsoleHelper.writeMessage(order.toString());
        try {
            advertisementManager.processVideos();
            queue.put(order);
        }catch (NoVideoAvailableException e){
            logger.log(Level.INFO, "No video is available for the order " + order);
        }catch (InterruptedException e){
            e.printStackTrace();
        }

    }

    @Override
    public String toString() {
        return "Tablet{" +
                "number=" + number +
                '}';
    }
}
