package com.example.rocketjava;

public class U1 extends Rocket  {

    public boolean launch(Item item) {
        int chanceOfLaunchExplosion = 5 * (item.weight / liftingWeight);

        if(chanceOfLaunchExplosion > 0) {
            return true;
        } else {
            return false;
        }
    }

    public boolean land(Item item) {
        int chanceOfLaunchExplosion = 1 * (item.weight / liftingWeight);

        if(chanceOfLaunchExplosion > 0) {
            return true;
        } else {
            return false;
        }
    }

    U1() {
        super(100, 10, 18);
    }
}
