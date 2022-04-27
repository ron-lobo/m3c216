package com.m3.c216.classes;

public class Vehicle {

    private final String make;
    private final String model;
    private String colour;
    private int numDoors = 0;
    private int speedKMH;

    public Vehicle(String make, String model) {
        this(make, model, null);
    }

    public Vehicle(String make, String model, String colour) {
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
        Vehicle v = (Vehicle) obj;
        return v.getMake().equals(getMake())
                && v.getModel().equals(getModel())
                && v.getColour().equals(getColour())
                && v.numDoors == numDoors;
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
