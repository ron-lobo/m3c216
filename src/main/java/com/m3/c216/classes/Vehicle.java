package com.m3.c216.classes;

public class Vehicle {

    private String make;
    private String model;
    private String colour;
    private int speedKMH;

    public Vehicle() {
        System.out.println("creating a new Vehicle");
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


    public void setMake(String m) {
        make = m;
    }

    public void setModel(String model) {
        this.model = model;
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
