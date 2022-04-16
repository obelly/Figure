package com.company.Car;

public class FordFactory implements Factory {

    @Override
    public Car createCar() {
        return new FordCar();
    }

    @Override
    public Transmission createTransmission() {
        return new Automate();
    }
}
