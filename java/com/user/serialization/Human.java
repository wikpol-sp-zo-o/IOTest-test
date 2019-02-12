package com.user.serialization;


import java.io.Serializable;

public class Human implements Serializable {

    String name;
    String surname;
    int age;
    String sex;

    char like;
    boolean marriage;

    float moneyCash;
    transient double moneyInBank;


    public Human(String name, String surname, int age, String sex, char like, boolean marriage, float moneyCash, double moneyInBank) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.sex = sex;
        this.like = like;
        this.marriage = marriage;
        this.moneyCash = moneyCash;
        this.moneyInBank = moneyInBank;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public char getLike() {
        return like;
    }

    public void setLike(char like) {
        this.like = like;
    }

    public boolean isMarriage() {
        return marriage;
    }

    public void setMarriage(boolean marriage) {
        this.marriage = marriage;
    }

    public float getMoneyCash() {
        return moneyCash;
    }

    public void setMoneyCash(float moneyCash) {
        this.moneyCash = moneyCash;
    }

    public double getMoneyInBank() {
        return moneyInBank;
    }

    public void setMoneyInBank(double moneyInBank) {
        this.moneyInBank = moneyInBank;
    }


}
