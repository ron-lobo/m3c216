package com.m3.c216.vehicle;

public class Car {

    private final String make;
    private final String model;
    private String colour;
    private int numDoors = 0;
    private int speedKMH;

    public Car(String make, String model) {
        this(make, model, null);
    }

    public Car(String make, String model, String colour) {
        this.make = make;
        this.model = model;
        this.colour = colour;
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
        return "Vehicle {" +
                "make=" + make +
                ", model=" + getModel() +
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
        return isEqual(v.make, make) &&
                isEqual(v.model, model) &&
                isEqual(v.colour, colour)
                && v.numDoors == numDoors;
    }

    private boolean isEqual(String s1, String s2) {
        return (s1 == null && s2 == null) || (s1 != null && s1.equals(s2));
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

    public String getColour() {
        return colour;
    }

    public int getSpeedKMH() {
        return speedKMH;
    }
}
