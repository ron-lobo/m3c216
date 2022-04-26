package com.m3.c216;

import com.m3.c216.classes.Vehicle;

public class VehicleUser {

    public static void main(String[] args) {
        Vehicle vehicle1 = new Vehicle("Ford", "Escort", "blue");
        Vehicle vehicle2 = new Vehicle("VW", "Golf", "black");

        showVehicles(vehicle1, vehicle2);

        vehicle1.accelerate(3);
        vehicle2.accelerate(10);

        showVehicles(vehicle1, vehicle2);

        vehicle1.brake(2, false);
        vehicle2.brake(1, true);

        Vehicle vehicle3 = new Vehicle("Volvo", "Tank");
        vehicle3.setColour("Pink");

        showVehicles(vehicle1, vehicle2, vehicle3);
    }

    private static void showVehicles(Vehicle... vehicles) {
        System.out.println("Vehicle Status");
        for (Vehicle vehicle : vehicles) {
            System.out.println("  " + vehicle);
        }
        System.out.println();
    }
}
