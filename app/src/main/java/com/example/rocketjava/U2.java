package com.example.rocketjava;

public class U2 extends Rocket {

    public boolean launch(Item item) {
        int chanceOfLaunchExplosion = 4 * (item.weight / liftingWeight);

        if(chanceOfLaunchExplosion > 0) {
            return true;
        } else {
            return false;
        }
    }

    public boolean land(Item item) {
        int chanceOfLaunchExplosion = 8 * (item.weight / liftingWeight);

        if(chanceOfLaunchExplosion > 0) {
            return true;
        } else {
            return false;
        }
    }

    U2() {
        super(120, 18, 29);
    }
}