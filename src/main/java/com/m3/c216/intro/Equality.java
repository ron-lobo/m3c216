package com.m3.c216.intro;

import com.m3.c216.vehicle.Car;

import java.util.ArrayList;
import java.util.List;

public class Equality {

    private List<Car> cars = new ArrayList<>();

    private void readFromDB() {
        // simulation (JDBC)
        Car v1 = new Car("Renault", "5", "yellow");
        Car v2 = new Car("Peugeot", "206", "blue");
        cars.add(v1);
        cars.add(v2);
        cars.add(new Car("Citroen", "2CV", "mauve"));
    }

    private Car getUserInput() {
        // simulation (Scanner)
        Car v1 = new Car("Renault", "5", "yellow");
        return v1;
    }

    public static void main(String[] args) {
        Equality equality = new Equality();
        equality.readFromDB();
        System.out.println("number of vehicles = " + equality.cars.size());
        Car v = equality.getUserInput();
        if (!equality.cars.contains(v)) {
            equality.cars.add(v);
        }
        System.out.println("number of vehicles = " + equality.cars.size());
        System.out.println();

        Car car = equality.cars.get(0);
        Car car1 = new Car("Ford", "Fiesta");
        Car car2 = new Car("Renault", "5");
        System.out.println(car);
        System.out.println("null comparison: " + car.equals(null));
        System.out.println("String comparison: " + car.equals("123"));
        System.out.println("same obj comparison: " + car.equals(car));
        System.out.println("Fiesta comparison: " + car.equals(car1));
        System.out.println("R5 comparison: " + car.equals(car2));
    }
}
