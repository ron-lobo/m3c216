package com.m3.c216.classes;

public class Vehicle {

    private final String make;
    private final String model;
    private String colour;
    private int speedKMH;

    public Vehicle(String make, String model) {
        this(make, model, null);
    }

    public Vehicle(String make, String model, String colour) {
        System.out.println("creating a new Vehicle");
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
        return speedKMH;
    }

    @Override
    public String toString() {
        return String.format("%s %s %s %d kmh", make, getModel(), getColour(), getSpeedKMH());
    }


    public void setColour(String colour) {
        this.colour = colour;
    }

    public String getMake() {
        return "Vehicle Make is: " + make.toUpperCase();
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
