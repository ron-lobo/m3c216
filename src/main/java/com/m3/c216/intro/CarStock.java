package com.m3.c216.intro;

import com.m3.c216.vehicle.Car;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CarStock {

    private final List<Car> cars = new ArrayList<>();

    public void buyCar(Car car) {
        cars.add(car);
    }

    public void sellCar(Car car) {
        cars.remove(car);
    }

    public void exchange(Car car1, Car car2) {
        cars.add(car1);
        cars.remove(car2);
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }
}
