package com.quantumcar;

public class Car {
    private IEngine engine;
    private int speed = 0;
    private boolean running = false;

    public Car(IEngine engine) {
        this.engine = engine;
    }

    public void setEngine(IEngine engine) {
        this.engine = engine;
        System.out.println("Engine replaced.");
    }

    public void start() {
        speed = 0;
        running = true;
        System.out.println("Car started at speed 0.");
    }

    public void stop() {
        if (speed != 0) {
            System.out.println("Cannot stop: bring speed to 0 first. Current: " + speed);
            return;
        }
        running = false;
        System.out.println("Car stopped.");
    }

    public void accelerate() {
        if (!running) { System.out.println("Start the car first."); return; }
        if (speed >= 200) { System.out.println("Already at max speed 200."); return; }
        for (int i = 0; i < 20; i++) {
            speed++;
            engine.increase();
        }
        System.out.println("--- Accelerated to: " + speed + " km/h ---");
    }

    public void brake() {
        if (!running) { System.out.println("Car is not running."); return; }
        for (int i = 0; i < 20; i++) {
            if (speed == 0) break;
            speed--;
            engine.decrease();
        }
        System.out.println("--- Braked to: " + speed + " km/h ---");
    }
}