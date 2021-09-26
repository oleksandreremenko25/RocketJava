package com.example.rocketjava;

public class Rocket implements SpaceShip {
    int rocketCost;
    int currentWeight;
    int maxWeight;
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

        if (canCarry(item)) {
            currentWeight = currentWeight + item.weight;
        }

        return  currentWeight;
    };

    Rocket(int rocketCost, int currentWeight, int maxWeight) {
        this.rocketCost = rocketCost;
        this.currentWeight = currentWeight;
        this.maxWeight = maxWeight;
        liftingWeight = maxWeight - currentWeight;
    }
}