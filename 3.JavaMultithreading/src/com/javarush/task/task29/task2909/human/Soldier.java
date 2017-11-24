package com.javarush.task.task29.task2909.human;

import java.util.List;

public class Soldier extends Human {

    public Soldier(String name, int age) {
        super(name,age);
    }

    @Override
    public void setBloodGroup(BloodGroup bloodGroup) {
        super.setBloodGroup(bloodGroup);
    }

    @Override
    public BloodGroup getBloodGroup() {
        return super.getBloodGroup();
    }


    @Override
    public int getAge() {
        return super.getAge();
    }

    @Override
    public void setAge(int age) {
        super.setAge(age);
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public void setName(String name) {
        super.setName(name);
    }


    @Override
    public void live() {
        fight();
    }

    public void fight() {
    }

    @Override
    public int getId() {
        return super.getId();
    }

    @Override
    public void printSize() {
        super.printSize();
    }
}
