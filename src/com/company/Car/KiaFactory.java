package com.company.Car;

public class KiaFactory implements Factory {
    @Override
    public Car createCar() {
        return new KiaCar();
    }

    @Override
    public Transmission createTransmission() {
        return new Manual();
    }
}
