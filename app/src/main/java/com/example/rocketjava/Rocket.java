package com.example.rocketjava;

public abstract class Rocket implements SpaceShip {
    int rocketCost;
    int currentWeight;
    int maxWeight;
    int emptyWeight;

    public boolean launch() {
        return true;
    }

    public boolean land() {
        return true;
    }

    public boolean canCarry(Item item) {
        return (maxWeight >= (item.weight + currentWeight));
    }

    public int carry(Item item) {
        return currentWeight = currentWeight + item.weight;
    }

    Rocket(int rocketCost, int currentWeight, int maxWeight) {
        this.rocketCost = rocketCost;
        this.currentWeight = currentWeight;
        this.maxWeight = maxWeight;
        this.emptyWeight = currentWeight;
    }

}