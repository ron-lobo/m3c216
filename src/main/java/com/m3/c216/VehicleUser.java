package com.m3.c216;

import com.m3.c216.vehicle.Car;
import com.m3.c216.vehicle.Engine;

public class VehicleUser {

    public static void main(String[] args) {
        VehicleUser vu = new VehicleUser();
        vu.testCars();
        vu.testEngines();
    }

    public void testEngines() {
        Engine e1 = new Engine(null, 1600);
        Engine e2 = new Engine("v6", 2000);
        Engine e3 = new Engine("4cyl", 1600);

        showObjects("Engine", e1, e2);
        System.out.println("e1 e2 equality:" + e2.equals(e1));
        System.out.println("e1 e3 equality:" + e1.equals(e3));
    }

    public void testCars() {
        Car car1 = new Car("Ford", "Escort", "blue");
        Car car2 = new Car("VW", "Golf", "black");

        showObjects("Car", car1, car2);

        car1.accelerate(3);
        car2.accelerate(10);

        showObjects("Car", car1, car2);

        car1.brake(2, false);
        car2.brake(1, true);

        Car car3 = new Car("Volvo", "Tank");
        car3.setColour("Pink");

        showObjects("Car", car1, car2, car3);
    }

    private void showObjects(String name, Object... objects) {
        System.out.println("\n" + name + " status:");
        for (Object obj : objects) {
            System.out.println("  " + obj);
        }
    }
}
