package com.example.rocketjava;

public class U2 extends Rocket {

    @Override
    public boolean launch() {
        int chanceOfLaunchExplosion = 5 * ((currentWeight - emptyWeight) / (maxWeight - emptyWeight));
        return chanceOfLaunchExplosion < Math.random() * 7;
    }

    @Override
    public boolean land() {
        int chanceOfLaunchExplosion = 8 * ((currentWeight - emptyWeight) / (maxWeight - emptyWeight));
        return chanceOfLaunchExplosion < Math.random() * 14;
    }

    U2() {
        super(120, 18, 29);
    }
}