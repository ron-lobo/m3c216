package com.m3.c216;

import com.m3.c216.classes.Vehicle;

public class VehicleUser {

    public static void main(String[] args) {
        Vehicle vehicle1 = new Vehicle("Ford", "Escort", "blue");
        Vehicle vehicle2 = new Vehicle("VW", "Golf", "black");
        Vehicle vehicle3 = new Vehicle("Volvo", "red");

        showVehicles(vehicle1, vehicle2);

        vehicle1.accelerate(3);
        vehicle2.accelerate(10);

        vehicle1.setColour("Pink");

        showVehicles(vehicle1, vehicle2);

        vehicle1.brake(2, false);
        vehicle2.brake(1, true);

        showVehicles(vehicle1, vehicle2);
    }

    private static void showVehicles(Vehicle v1, Vehicle v2) {
        System.out.println(v1);
        System.out.println(v2);
    }
}
