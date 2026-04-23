package com.quantumcar;
// Main.java
public class Main {
    public static void main(String[] args) {
        CarFactory factory = new CarFactory();

        System.out.println("=== Gas Car ===");
        Car gasCar = factory.createCar(CarFactory.EngineType.GAS);
        gasCar.start();
        gasCar.accelerate();
        gasCar.brake();
        gasCar.brake();
        gasCar.stop();

        System.out.println("\n=== Electric Car ===");
        Car electricCar = factory.createCar(CarFactory.EngineType.ELECTRIC);
        electricCar.start();
        electricCar.accelerate();
        electricCar.stop(); // will fail — speed not 0
        electricCar.brake();
        electricCar.stop(); // still > 0
        // brake down fully
        for (int i = 0; i < 10; i++) electricCar.brake();
        electricCar.stop();

        System.out.println("\n=== Hybrid Car + Engine Replace ===");
        Car hybridCar = factory.createCar(CarFactory.EngineType.HYBRID);
        hybridCar.start();
        hybridCar.accelerate(); // 0 -> 20, electric
        hybridCar.accelerate(); // 20 -> 40, electric
        hybridCar.accelerate(); // 40 -> 60, switches to gas at 50
        hybridCar.brake();      // back toward electric
        factory.replaceEngine(hybridCar, CarFactory.EngineType.GAS);
        hybridCar.accelerate();
    }
}