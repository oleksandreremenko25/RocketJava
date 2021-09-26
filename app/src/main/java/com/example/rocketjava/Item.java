package com.example.rocketjava;

public class Item {
    public String name;
    public int weight;

    Item (String name, int weight) {
        this.name = name;
        this.weight = weight/1000;
    }
}