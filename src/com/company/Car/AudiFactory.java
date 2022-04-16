package com.company.Car;

public class AudiFactory implements Factory{
    @Override
    public Car createCar() {
        return new AudiCar();
    }

    @Override
    public Transmission createTransmission() {
        return new Robot();
    }
}
