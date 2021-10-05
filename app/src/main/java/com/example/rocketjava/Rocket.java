package com.example.rocketjava;

public abstract class Rocket implements SpaceShip {
    int rocketCost;
    int currentWeight;
    int maxWeight;
    int emptyWeight;
    int liftingWeight;

    public boolean launch() {
        return true;
    };

    public boolean land() {
        return true;
    };

    public boolean canCarry(Item item) {
        if (maxWeight >= (item.weight + currentWeight)) {
            return true;
        } else {
            return false;
        }
    };

    public int carry(Item item) {
        return currentWeight = currentWeight + item.weight;
    };

    Rocket(int rocketCost, int currentWeight, int maxWeight) {
        this.rocketCost = rocketCost;
        this.currentWeight = currentWeight;
        this.maxWeight = maxWeight;
        this.emptyWeight = currentWeight;
        liftingWeight = maxWeight - currentWeight;
    }

}