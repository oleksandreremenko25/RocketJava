package com.example.rocketjava;

public class U1 extends Rocket  {

    @Override
    public boolean launch() {
        int chanceOfLaunchExplosion = 5 * ((currentWeight - emptyWeight) / (maxWeight - emptyWeight));
        return chanceOfLaunchExplosion < Math.random() * 9;
    }

    @Override
    public boolean land() {
        int chanceOfLaunchExplosion = 1 * ((currentWeight - emptyWeight) / (maxWeight - emptyWeight));
        return chanceOfLaunchExplosion < Math.random() * 5;
    }

    U1() {
        super(100, 10, 18);
    }
}
