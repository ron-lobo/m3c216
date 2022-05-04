package com.m3.c216.vehicle;

import java.util.Objects;

public class Car {

    private final String make;
    private final String model;
    private Engine engine;
    private String colour;
    private final int numDoors;
    private int speedKMH;

    public Car(String make, String model) {
        this(make, model, null);
    }

    public Car(String make, String model, String colour) {
        this(make, model, colour, 4, null);
    }

    public Car(String make, String model, String colour, int numDoors, Engine engine) {
        this.make = make;
        this.model = model;
        this.engine = engine;
        this.colour = colour;
        this.numDoors = numDoors;
    }

    public int accelerate(double d) {
        speedKMH += d * 10;
        return speedKMH;
    }

    public int brake(double d, boolean isEmergency) {
        if (isEmergency && d == 1) {
            speedKMH = 0;
        } else {
            speedKMH -= d * 10;
        }
        if (speedKMH < 0) speedKMH = 0;
        return speedKMH;
    }

    @Override
    public String toString() {
        return "Car {" +
                "make=" + make +
                ", model=" + getModel() +
                ", engine=" + engine +
                ", colour=" + colour +
                ", numDoors=" + numDoors +
                ", speedKML=" + speedKMH +
                "}";
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || obj.getClass() != getClass()) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        Car v = (Car) obj;
        return Objects.equals(v.make, make) &&
                Objects.equals(v.model, model) &&
                Objects.equals(v.engine, engine) &&
                Objects.equals(v.colour, colour)
                && v.numDoors == numDoors;
    }

    @Override
    public int hashCode() {
        return Objects.hash(make, model, engine, colour, numDoors);
    }


    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public Engine getEngine() {
        return engine;
    }

    public String getColour() {
        return colour;
    }

    public int getSpeedKMH() {
        return speedKMH;
    }

    public int getNumDoors() {
        return numDoors;
    }
}
