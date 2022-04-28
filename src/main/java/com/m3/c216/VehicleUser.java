package com.m3.c216;

import com.m3.c216.vehicle.Car;

public class VehicleUser {

    public static void main(String[] args) {
        Car car1 = new Car("Ford", "Escort", "blue");
        Car car2 = new Car("VW", "Golf", "black");

        showVehicles(car1, car2);

        car1.accelerate(3);
        car2.accelerate(10);

        showVehicles(car1, car2);

        car1.brake(2, false);
        car2.brake(1, true);

        Car car3 = new Car("Volvo", "Tank");
        car3.setColour("Pink");

        showVehicles(car1, car2, car3);
    }

    private static void showVehicles(Car... cars) {
        System.out.println("Vehicle Status");
        for (Car car : cars) {
            System.out.println("  " + car);
        }
        System.out.println();
    }
}
