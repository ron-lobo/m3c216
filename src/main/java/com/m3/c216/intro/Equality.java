package com.m3.c216.intro;

import com.m3.c216.vehicle.Car;
import com.m3.c216.vehicle.Engine;

import java.util.ArrayList;
import java.util.List;

public class Equality {

    private List<Car> cars = new ArrayList<>();

    private void readFromDB() {
        // simulation (JDBC)
        Engine e1 = new Engine("v6", 3000);
        Engine e2 = new Engine("v8", 2400);
        Car v1 = new Car("Renault", "5", "yellow", 2, new Engine("4cyl", 1100));
        Car v2 = new Car("Peugeot", "206", "blue", 2, e1);
        cars.add(v1);
        cars.add(v2);
        cars.add(new Car("Citroen", "2CV", "mauve"));
    }

    private Car getUserInput() {
        // simulation (Scanner)
        Car v1 = new Car("Renault", "5", "yellow", 2, null);
        Engine e1 = new Engine("4cyl", 1100);
        v1.setEngine(e1);
        return v1;
    }

    public static void main(String[] args) {
        Equality equality = new Equality();
        equality.test1();
        equality.test2();
    }

    public void test1() {
        readFromDB();
        System.out.println("number of vehicles = " + cars.size());
        Car v = getUserInput();
        if (!cars.contains(v)) {
            cars.add(v);
        }
        System.out.println("number of vehicles = " + cars.size());
        System.out.println();
    }

    public void test2() {
        Car car = cars.get(0);
        Car car1 = new Car("Ford", "Fiesta");
        Car car2 = new Car("Renault", "5", "yellow", 2, new Engine("4cyl", 1100));
        System.out.println(car);
        System.out.println(car1);
        System.out.println(car2);
        System.out.println("null comparison: " + car.equals(null));
        System.out.println("String comparison: " + car.equals("123"));
        System.out.println("same obj comparison: " + car.equals(car));
        System.out.println("Fiesta comparison: " + car.equals(car1));
        System.out.println("R5 comparison: " + car.equals(car2));
    }
}
