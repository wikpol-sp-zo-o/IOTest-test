package com.user.serialization;

import java.io.Serializable;
import java.util.ArrayList;

public class World implements Serializable {

    private String name;

    private ArrayList<Human> humanArrayList = new ArrayList<>();


    public World(String name) {
        this.name = name;
    }

    public String showHumans() {

        StringBuilder result = new StringBuilder();

        for (Human human : humanArrayList) {

            result.append(human.getName()).append("\n");
            result.append(human.getSurname()).append("\n");
            result.append(human.getAge()).append("\n");
            result.append(human.getSex()).append("\n");
            result.append(human.getLike()).append("\n");
            result.append(human.isMarriage()).append("\n");
            result.append(human.getMoneyCash()).append("\n");
            result.append(human.getMoneyInBank()).append("\n").append("\n");

        }

        return result.toString();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Human> getHumanArrayList() {
        return humanArrayList;
    }

    public void setHumanArrayList(ArrayList<Human> humanArrayList) {
        this.humanArrayList = humanArrayList;
    }

}
