package com.javarush.task.task27.task2712.ad;

import java.util.ArrayList;
import java.util.List;

public class StatisticAdvertisementManager {
    private static StatisticAdvertisementManager instance = new StatisticAdvertisementManager();
    private AdvertisementStorage advertisementStorage = AdvertisementStorage.getInstance();

    private StatisticAdvertisementManager() {
    }

    public static StatisticAdvertisementManager getInstance() {
        if (instance == null)
            instance = new StatisticAdvertisementManager();
        return instance;
    }

    public List<Advertisement> getActiveAds(){
        //получить лист со всеми видео
        List<Advertisement> list = advertisementStorage.list();
        //
        List<Advertisement> resultList = new ArrayList<>();

        for (Advertisement ad : list) {
            if (ad.getHits()>0){
                resultList.add(ad);
            }
        }
        return resultList;
    }

    public List<Advertisement> getArchivedAds(){
        //получить лист со всеми видео
        List<Advertisement> list = advertisementStorage.list();
        //
        List<Advertisement> resultList = new ArrayList<>();

        for (Advertisement ad : list) {
            if (ad.getHits()<=0){
                resultList.add(ad);
            }
        }
        return resultList;
    }
}
