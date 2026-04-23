package com.quantumcar;
public class CarFactory {
    public enum EngineType { GAS, ELECTRIC, HYBRID }
    public Car createCar(EngineType type) {
        return new Car(buildEngine(type));
    }
    public void replaceEngine(Car car, EngineType type) {
        car.setEngine(buildEngine(type));
    }
    private IEngine buildEngine(EngineType type) {
        return switch (type) {
            case GAS -> new GasEngine();
            case ELECTRIC -> new ElectricEngine();
            case HYBRID   -> new HybridEngine();
        };
    }
}
