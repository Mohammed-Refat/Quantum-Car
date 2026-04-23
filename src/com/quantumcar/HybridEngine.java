package com.quantumcar;

// MixedHybridEngine.java
public class HybridEngine implements IEngine {
    private final GasEngine gasEngine = new GasEngine();
    private final ElectricEngine electricEngine = new ElectricEngine();
    private int speed = 0;
    private IEngine getActive() {
        return speed < 50 ? electricEngine : gasEngine;
    }
    @Override
    public void increase() {
        IEngine before = getActive();
        speed++;
        IEngine after = getActive();
        if (before != after) {
            System.out.println("Hybrid switched to gas at speed " + speed);
        } else {
            after.increase();
        }
    }
    @Override
    public void decrease() {
        IEngine before = getActive();
        if (speed > 0) speed--;
        IEngine after = getActive();
        if (before != after) {
            System.out.println("Hybrid switched to electric at speed " + speed);
        } else {
            after.decrease();
        }
    }
}