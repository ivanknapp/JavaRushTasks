package com.javarush.task.task27.task2712.ad;

import com.javarush.task.task27.task2712.ConsoleHelper;
import com.javarush.task.task27.task2712.statistic.StatisticManager;
import com.javarush.task.task27.task2712.statistic.event.VideoSelectedEventDataRow;

import java.util.*;

public class AdvertisementManager {
    private final AdvertisementStorage storage = AdvertisementStorage.getInstance();
    private int timeSeconds;

    public AdvertisementManager(int timeSeconds) {
        this.timeSeconds = timeSeconds;
    }
/*
    public void processVideos() {
        List<Advertisement> validAds = new ArrayList<>();
        for (Advertisement ad : storage.list()) {
            if (ad.getDuration() <= timeSeconds && ad.getHits() > 0){
                validAds.add(ad);
            }
        }
        if (validAds.isEmpty()) {
            throw new NoVideoAvailableException();
        } else {
            List<List<Advertisement>> combinationsOfVideos = new ArrayList<>();
            //собираем всевозможные комбинации видео роликов
            for (int i = 1; i <= validAds.size(); i++) {
                combinationsOfVideos.addAll(combination(validAds, i));
            }
            //определяем наилучший список видео
            List<Advertisement> favorableList = getFavorableList(combinationsOfVideos);
            //уменьшаем количество показов у всех видео
            revalidateVideos(favorableList);
            //сортируем по стоимости показа
            sort(favorableList);
            //выводим на экран
            printVideos(favorableList);

        }
    }
*/

    public void processVideos() throws NoVideoAvailableException{
        // ищем список видео для показа согласно критериям
        List<Advertisement> bestAds = new VideoHelper().findAllYouNeed();
        // сортируем полученный список
        Collections.sort(bestAds, new Comparator<Advertisement>() {
            @Override
            public int compare(Advertisement video1, Advertisement video2) {
                long dif = video2.getAmountPerOneDisplaying() - video1.getAmountPerOneDisplaying();
                if (dif == 0) dif = video2.getDuration()- video1.getDuration();
                return (int) dif;
            }
        });
        //Статистика: добавляем событие в базу
        StatisticManager statisticManager = StatisticManager.getInstance();
        VideoSelectedEventDataRow eventDataRow = new VideoSelectedEventDataRow(bestAds, getTotalCost(bestAds), getTotalTime(bestAds));
        statisticManager.register(eventDataRow);

        // выводим список
        for (Advertisement ad : bestAds){
            ConsoleHelper.writeMessage( ad.getName() + " is displaying... " +
                    ad.getAmountPerOneDisplaying() + ", " +
                    1000 * ad.getAmountPerOneDisplaying()/ad.getDuration() );
            ad.revalidate();
        }
    }

    public void printVideos(List<Advertisement> list){
        for (Advertisement ad : list) {
            long costPerSec = ad.getAmountPerOneDisplaying()*1000/ad.getDuration();
            System.out.println(ad.getName() + " is displaying... " + ad.getAmountPerOneDisplaying() + ", " + costPerSec);
        }
    }

    public void sort(List<Advertisement> list){
        Collections.sort(list, new Comparator<Advertisement>() {
            @Override
            public int compare(Advertisement o1, Advertisement o2) {
                return (int) (o2.getAmountPerOneDisplaying() - o1.getAmountPerOneDisplaying());
            }
        });

/*        Collections.sort(list, new Comparator<Advertisement>() {
            @Override
            public int compare(Advertisement o1, Advertisement o2) {
                int costPerSecO1 = (int) (o1.getAmountPerOneDisplaying()*1000/o1.getDuration());
                int costPerSecO2 = (int) (o2.getAmountPerOneDisplaying()*1000/o2.getDuration());
                return costPerSecO1 - costPerSecO2;
            }
        });*/
    }

    public static <T> List<List<T>> combination(List<T> values, int size) {

        if (0 == size) {
            return Collections.singletonList(Collections.<T>emptyList());
        }
        if (values.isEmpty()) {
            return Collections.emptyList();
        }

        List<List<T>> combination = new LinkedList<List<T>>();

        T actual = values.iterator().next();

        List<T> subSet = new LinkedList<T>(values);
        subSet.remove(actual);

        List<List<T>> subSetCombination = combination(subSet, size - 1);

        for (List<T> set : subSetCombination) {
            List<T> newSet = new LinkedList<T>(set);
            newSet.add(0, actual);
            combination.add(newSet);
        }

        combination.addAll(combination(subSet, size));

        return combination;
    }

    public boolean checkTime(List<Advertisement> list) {
        int totalTime = 0;
        for (Advertisement ad : list) {
            totalTime += ad.getDuration();
        }
        return totalTime <= timeSeconds;
    }

    public int getTotalTime(List<Advertisement> list) {
        int totalTime = 0;
        for (Advertisement ad : list) {
            totalTime += ad.getDuration();
        }
        return totalTime;
    }

    public long getTotalCost(List<Advertisement> list) {
        long totalCost = 0;
        for (Advertisement ad : list) {
            totalCost += ad.getAmountPerOneDisplaying();
        }
        return totalCost;
    }

    public boolean checkRevalidate(List<Advertisement> list) {
        for (Advertisement ad : list) {
            if (ad.getHits() <=0){
                return false;
            }
        }
        return true;
    }

    public void revalidateVideos(List<Advertisement> list) {
        for (Advertisement ad : list) {
            if (ad.getHits()>0){
                ad.revalidate();
            }
        }
    }

    public List<Advertisement> getFavorableList(List<List<Advertisement>> list) {
        List<List<Advertisement>> copyList = new ArrayList<>(list);
        List<Advertisement> favorableList = copyList.get(1);
        for (List<Advertisement> adList : list) {
            //5. количество показов у любого рекламного
            // ролика из набора - положительное число.
            if (checkRevalidate(adList)) {
                //2. общее время показа рекламных роликов НЕ должно
                //превышать время приготовления блюд для текущего заказа;
                if (checkTime(adList)) {
                    //1. сумма денег, полученная от показов, должна быть
                    //максимальной из всех возможных вариантов
                    if (getTotalCost(favorableList) <= getTotalCost(adList)) {
                        //4. если существует несколько вариантов набора видео-роликов
                        //с одинаковой суммой денег, полученной от показов, то:
                        if (getTotalCost(favorableList) == getTotalCost(adList)) {
                            //4.1. выбрать тот вариант, у которого суммарное время максимальное;
                            if (getTotalTime(favorableList) <= getTotalTime(adList)) {
                                //4.2. если суммарное время у этих вариантов одинаковое,
                                if (getTotalTime(favorableList) == getTotalTime(adList)) {
                                    // то выбрать вариант с минимальным количеством роликов;
                                    if (favorableList.size() > adList.size()) {
                                        favorableList = adList;
                                    }
                                } else {
                                    favorableList = adList;
                                }
                            }
                        } else {
                            favorableList = adList;
                        }
                    }
                }
            }
        }

        return favorableList;


    }

    private class VideoHelper {
        private int bestPrice = 0;
        private int maxTime = 0;
        private int numberOfClips = 0;
        private List<Advertisement> bestAds = new ArrayList<>();
        private List<Advertisement> candidates = new ArrayList<>();

        public List<Advertisement> findAllYouNeed(){
            // отбор кандидатов
            for (Advertisement ad: storage.list()) {
                if (ad.getDuration() <= timeSeconds && ad.getHits() > 0)
                    candidates.add(ad);
            }
            if (candidates.isEmpty()) {
                throw new NoVideoAvailableException();
            }
            else findBestAds(new BinaryPattern(candidates.size()));
            return bestAds;
        }
        // рекурсивная функция формирования списка для показа
        public void findBestAds(BinaryPattern pattern) {
            while (true){
                checkAds(pattern.getPattern());
                if(!pattern.full()) pattern.increment();
                else break;
                findBestAds(pattern);
            }
        }
        // проверка очередного набора видеоклипов
        private void checkAds(int[] pattern){
            int price = 0;
            int time = 0;
            List<Advertisement> list = new ArrayList<>();
            for (int i = 0; i < candidates.size(); i++) {
                price += candidates.get(i).getAmountPerOneDisplaying() * pattern[i];
                time += candidates.get(i).getDuration() * pattern[i];
                if (pattern[i] == 1) list.add(candidates.get(i));
            }
            if (time > timeSeconds) return;
            if (!(price > bestPrice)) {
                if (!(price == bestPrice && time > maxTime)){
                    if (!(price == bestPrice && time == maxTime && list.size() < numberOfClips)){
                        return;
                    }
                }
            }
            bestAds = list;
            bestPrice = price;
            maxTime = time;
            numberOfClips = list.size();
        }
        // формирование двоичных масок для сбора списка видеоклипов
        private class BinaryPattern{
            private int length;
            private int count;
            public BinaryPattern(int size) {
                this.length = size;
                this.count = 0;
            }
            public int[] getPattern(){
                String regString = Integer.toBinaryString(count);
                int dif = length - regString.length();
                int[] pattern = new int[length];
                for (int j = dif; j < pattern.length ; j++) {
                    if (regString.charAt(j - dif) == '1') pattern[j] = 1;
                    else pattern[j] = 0;
                }
                return pattern;
            }
            public void increment(){ count++; };
            public boolean full(){return count == (int)Math.pow(2, length)-1;}
        }
    }
}
