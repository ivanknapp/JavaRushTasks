package com.javarush.task.task29.task2909.car;

import java.util.Date;

public abstract class Car {
    static public final int TRUCK = 0;
    static public final int SEDAN = 1;
    static public final int CABRIOLET = 2;

    static public final int MAX_SEDAN_SPEED = 120;
    static public final int MAX_TRUCK_SPEED = 80;
    static public final int MAX_CABRIOLET_SPEED = 90;

    double fuel;

    public double summerFuelConsumption;
    public double winterFuelConsumption;
    public double winterWarmingUp;

    private int type;

    private boolean driverAvailable;
    private int numberOfPassengers;

    public static Car create(int type, int numberOfPassengers){
        switch (type){
            case 0 : return new Truck(numberOfPassengers);
            case 1 : return new Sedan(numberOfPassengers);
            case 2 : return new Cabriolet(numberOfPassengers);
            default : return null;
        }
    }

    protected Car(int type, int numberOfPassengers) {
        this.type = type;
        this.numberOfPassengers = numberOfPassengers;
    }

    public void fill(double numberOfLiters) throws Exception {
        if (numberOfLiters < 0)
            throw new Exception();
        fuel += numberOfLiters;
    }

    public double getTripConsumption(Date date, int length, Date SummerStart, Date SummerEnd) {
        double consumption;
        if (isSummer(date, SummerStart, SummerEnd)) {
            consumption = getSummerConsumption(length);
        } else {
            consumption = getWinterConsumption(length);
        }
        return consumption;
    }

    public int getNumberOfPassengersCanBeTransferred() {
        if (canPassengersBeTransferred())
            return numberOfPassengers;
        return 0;
    }

    public boolean isDriverAvailable() {
        return driverAvailable;
    }

    public void setDriverAvailable(boolean driverAvailable) {
        this.driverAvailable = driverAvailable;
    }

    public void startMoving() {
        fastenDriverBelt();
        if (numberOfPassengers > 0)
            fastenPassengersBelts();
    }

    public void fastenPassengersBelts() {
    }

    public void fastenDriverBelt() {
    }

    abstract public int getMaxSpeed();

    public boolean isSummer(Date date , Date summerStart, Date summerEnd){
        long dateTime = date.getTime();
        if (dateTime >= summerStart.getTime() && dateTime <= summerEnd.getTime()){
            return true;
        }
        return false;
    }

    public double getWinterConsumption(int length){
        return winterFuelConsumption*length + winterWarmingUp;
    }

    public double getSummerConsumption(int length){
        return summerFuelConsumption*length;
    }

    private boolean canPassengersBeTransferred(){
        if (isDriverAvailable() && fuel>0){
            return true;
        }
        return false;
    }
}