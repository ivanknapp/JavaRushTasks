package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.ad.Advertisement;
import com.javarush.task.task27.task2712.ad.StatisticAdvertisementManager;
import com.javarush.task.task27.task2712.statistic.StatisticManager;
import com.javarush.task.task27.task2712.statistic.event.EventDataRow;
import com.javarush.task.task27.task2712.statistic.event.EventType;
import com.javarush.task.task27.task2712.statistic.event.VideoSelectedEventDataRow;

import java.text.SimpleDateFormat;
import java.util.*;

public class DirectorTablet {
    StatisticManager statisticManager = StatisticManager.getInstance();

    public void printAdvertisementProfit(){
        //Список событий по типу SELECTED_VIDEOS
        List<EventDataRow> list = statisticManager.get(EventType.SELECTED_VIDEOS);
        //Сортируем по убыванию даты
        Collections.sort(list, new Comparator<EventDataRow>() {
            @Override
            public int compare(EventDataRow o1, EventDataRow o2) {
                return o2.getTime() - o1.getTime();
            }
        });
        //результирующий словарь String - дата, Double - значение
        HashMap<String, Double> profitPerDay = new HashMap<>();
        //Список дней
        ArrayList<String> daysList = new ArrayList<>();
        //формат даты
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-YYYY", Locale.ENGLISH);
        //заполняем результирующий словарь датами с нулевым значением профита
        list.forEach(e -> profitPerDay.put(sdf.format(e.getDate()),0.0));
        //заполняем результирующий словарь значениями
        list.forEach(e -> profitPerDay.put(sdf.format(e.getDate()),
                profitPerDay.get(sdf.format(e.getDate()))+((VideoSelectedEventDataRow)e).getAmount()/100.0));
        //Текущаю дата крайняя в листе т.к мы отсортировали список
        String currentDate = sdf.format(list.get(0).getDate());
        String temp;
        //добавляем в список дат текущую
        daysList.add(currentDate);
        //для всх событий в списке, заполняем список дат
        //для того чтобы в конечном итоге вывести все даты по порядку
        for (EventDataRow event : list) {
            temp = sdf.format(event.getDate());
            if (!currentDate.equals(temp)){
                daysList.add(temp);
                currentDate = temp;
            }
        }
        //общее значение прибыли по видео
        double total = 0;
        for (String date : daysList) {
            System.out.println(String.format("%s - %.2f",date , profitPerDay.get(date)));
            total += profitPerDay.get(date);
        }
        System.out.println(String.format("Total - %.2f\n",total));
    }
    /*
    Метод выводит загрузку поваров по дням,
    если повар в этот день не работал, то его имя не выводится
    загрузка поваров в минутах
     */
    public void printCookWorkloading(){
        String date;
        HashMap<String, Integer> cooksWorkTime;
        ArrayList<String> cooksName = new ArrayList<>();
        HashMap<String, HashMap<String, Integer>> cooksWorkLoading = statisticManager.getCooksWorkLoading();

        for (Map.Entry<String, HashMap<String, Integer>> pair : cooksWorkLoading.entrySet()) {
            date = pair.getKey();
            cooksWorkTime = pair.getValue();
            for (Map.Entry<String, Integer> cookPair : cooksWorkTime.entrySet()) {
                //Если повар не работал(то есть он есть в словаре, но суммарное
                //наработанное время у него 0) то не надо его выводить
                if (cookPair.getValue() != 0){
                    cooksName.add(cookPair.getKey());
                }
            }
            Collections.sort(cooksName);
            System.out.println(date);
            for (String name : cooksName) {
                if (cooksWorkTime.get(name) != 0)
                    System.out.println(String.format("%s - %d min", name, cooksWorkTime.get(name)));
            }
            System.out.println();

        }
    }

    public void printActiveVideoSet(){
        List<Advertisement> list = StatisticAdvertisementManager.getInstance().getActiveAds();
        Collections.sort(list, new Comparator<Advertisement>() {
            @Override
            public int compare(Advertisement o1, Advertisement o2) {
                return o1.getName().compareToIgnoreCase(o2.getName());
            }
        });
        for (Advertisement ad : list) {
            System.out.println(String.format("%s - %d", ad.getName(), ad.getHits()));
        }
    }

    public void printArchivedVideoSet(){
        List<Advertisement> list = StatisticAdvertisementManager.getInstance().getArchivedAds();
        Collections.sort(list, new Comparator<Advertisement>() {
            @Override
            public int compare(Advertisement o1, Advertisement o2) {
                return o1.getName().compareToIgnoreCase(o2.getName());
            }
        });
        for (Advertisement ad : list) {
            System.out.println(String.format("%s", ad.getName()));
        }
    }
}

