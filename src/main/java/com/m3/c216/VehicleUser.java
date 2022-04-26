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

        showVehicle(vehicle1);
        showVehicle(vehicle2);

        vehicle1.accelerate(3);
        vehicle2.accelerate(10);

        showVehicle(vehicle1);
        showVehicle(vehicle2);

        vehicle1.brake(2, false);
        vehicle2.brake(1, true);

        showVehicle(vehicle1);
        showVehicle(vehicle2);
    }

    public static void showVehicle(Vehicle v) {
        System.out.printf("%s %s %s %d kmh%n", v.getMake(), v.getModel(), v.getColour(), v.getSpeedKMH());
    }
}
