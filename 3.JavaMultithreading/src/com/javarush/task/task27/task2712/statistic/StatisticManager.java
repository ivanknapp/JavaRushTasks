package com.javarush.task.task27.task2712.statistic;

import com.javarush.task.task27.task2712.kitchen.Cook;
import com.javarush.task.task27.task2712.kitchen.Order;
import com.javarush.task.task27.task2712.statistic.event.CookedOrderEventDataRow;
import com.javarush.task.task27.task2712.statistic.event.EventDataRow;
import com.javarush.task.task27.task2712.statistic.event.EventType;

import java.text.SimpleDateFormat;
import java.util.*;

public class StatisticManager {
    private static StatisticManager instance;
    private StatisticStorage statisticStorage = new StatisticStorage();

    private StatisticManager() {
    }

    public static StatisticManager getInstance(){
        if (instance == null)
            instance = new StatisticManager();
        return instance;
    }

    public List<EventDataRow> get(EventType type){
        return statisticStorage.getData(type);
    }

    public void register(EventDataRow data){
        statisticStorage.put(data);
    }
    /*
    Метод возвращает словарь заполненный датами и наработкой
    соответсвующих поваров в эти даты
     */
    public HashMap<String, HashMap<String, Integer>> getCooksWorkLoading(){
        //словарь String - дата и Hashmap - поваров с наработкой по текущ дате
        HashMap<String, HashMap<String, Integer>> cooksWorkLoading = new HashMap<>();
        //промежуточный словарь
        // String - имя повара,
        // Integer - наработка
        HashMap<String, Integer> cookWorkTime = new HashMap<>();
        //Лист содержащий все события по типу COOKER_ORDER
        List<EventDataRow> orderEventList = get(EventType.COOKED_ORDER);

        //добавляем всех зарегистрированных поваров, в словарь
        //с нулевым значением наработки
        for (EventDataRow eventDataRow : orderEventList) {
            CookedOrderEventDataRow order = (CookedOrderEventDataRow)eventDataRow;
            cookWorkTime.put(order.getCookName(), 0);
        }

        //сортируем все события, вначале саммые ранние, затем более поздние
        Collections.sort(orderEventList, new Comparator<EventDataRow>() {
            @Override
            public int compare(EventDataRow o1, EventDataRow o2) {
                return o2.getTime() - o1.getTime();
            }
        });
        //Формат для сохранение дат
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-YYYY", Locale.ENGLISH);
        //текущий день - самый ранний
        String currentDay = sdf.format(orderEventList.get(0).getDate());
        String tempDay;
        CookedOrderEventDataRow eventOrder;

        //заполним результирующий словарь датами
        for (EventDataRow event : orderEventList) {
            cooksWorkLoading.put(sdf.format(event.getDate()),new HashMap<>(cookWorkTime));
        }

        for (EventDataRow event : orderEventList) {
            eventOrder = (CookedOrderEventDataRow) event; //текущ. заказ
            tempDay = sdf.format(event.getDate()); //текущ. день
            String cookName = eventOrder.getCookName();// текущ. повар
            HashMap<String, Integer> hashMap = cooksWorkLoading.get(tempDay);//текущ. промеж словарь
            Integer value = hashMap.get(eventOrder.getCookName());//значение наработки текущ. повара

            hashMap.put(cookName, value + eventOrder.getCookingTimeSeconds());
            cooksWorkLoading.put(tempDay, new HashMap<>(hashMap));
        }

/*        //цикл для всех элементов в списке событий
        for (EventDataRow event : orderEventList){
            //преобразуем event в OrderEvent для работы с ним
            eventOrder = (CookedOrderEventDataRow) event;
            tempDay = sdf.format(event.getDate());
            //Если событие было в тот же день, то
            //заполняем промежуточный словарь
            //и помещаем значение в результирующий словарь по текущ дате
            if (currentDay.equals(tempDay)){
                cookWorkTime.put(eventOrder.getCookName(), cookWorkTime.get(eventOrder.getCookName()) + eventOrder.getCookingTimeSeconds());
                cooksWorkLoading.put(tempDay, cookWorkTime);
            }else {
                cooksWorkLoading.put(tempDay, cookWorkTime);
                cookWorkTime = new HashMap<>();
                initCooks(cookWorkTime);
                cookWorkTime.put(eventOrder.getCookName(), eventOrder.getCookingTimeSeconds());
                currentDay = tempDay;
            }
        }*/

        return cooksWorkLoading;
    }

    /*
    Класс отвечающий за хранение событий
     */
    private class StatisticStorage{
        private Map<EventType, List<EventDataRow>> storage = new HashMap<EventType, List<EventDataRow>>();

        private StatisticStorage() {
            EventType[] array = EventType.values();
            for (EventType event : array) {
                this.storage.put(event, new ArrayList<EventDataRow>());
            }
        }

        private void put(EventDataRow data){
            storage.get(data.getType()).add(data);
        }

        private List<EventDataRow> getData(EventType type) {
            return storage.get(type);
        }
    }
}