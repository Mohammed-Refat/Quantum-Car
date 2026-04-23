package com.quantumcar;
public class ElectricEngine implements IEngine{
    private int speed = 0;
    @Override
    public void increase() {
        speed++;
        System.out.println("Electric speed: " + speed);
    }
    @Override
    public void decrease() {
        if (speed > 0) speed--;
        System.out.println("Electric speed: " + speed);
    }
}
