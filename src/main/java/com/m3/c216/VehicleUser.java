package com.m3.c216;

import com.m3.c216.classes.Vehicle;

public class VehicleUser {

    public static void main(String[] args) {
        Vehicle vehicle1 = new Vehicle();
        Vehicle vehicle2 = new Vehicle();

        vehicle1.setMake("Ford");
        vehicle1.setModel("Escort");
        vehicle1.setColour("blue");

        vehicle2.setMake("VW");
        vehicle2.setModel("Golf");
        vehicle2.setColour("black");

        System.out.printf("v1: %s %s %s %n", vehicle1.getMake(), vehicle1.getModel(), vehicle1.getColour());
        System.out.printf("v2: %s %s %s %n", vehicle2.getMake(), vehicle2.getModel(), vehicle2.getColour());
    }

}
