package com.m3.c216.classes;

public class Vehicle {

    private String make;
    private String model;
    private String colour;

    public Vehicle() {
        System.out.println("creating a new Vehicle");
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
        return make;
    }

    public String getModel() {
        return model;
    }

    public String getColour() {
        return colour;
    }
}
