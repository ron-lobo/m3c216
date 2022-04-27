package com.m3.c216.intro;

import com.m3.c216.classes.Vehicle;

import java.util.ArrayList;
import java.util.List;

public class Equality {

    private List<Vehicle> vehicles = new ArrayList<>();

    private void readFromDB() {
        // simulation (JDBC)
        Vehicle v1 = new Vehicle("Renault", "5", "yellow");
        Vehicle v2 = new Vehicle("Peugeot", "206", "blue");
        vehicles.add(v1);
        vehicles.add(v2);
        vehicles.add(new Vehicle("Citroen", "2CV", "mauve"));
    }

    private Vehicle getUserInput() {
        // simulation (Scanner)
        Vehicle v1 = new Vehicle("Renault", "5", "yellow");
        return v1;
    }

    public static void main(String[] args) {
        Equality equality = new Equality();
        equality.readFromDB();
        System.out.println("number of vehicles = " + equality.vehicles.size());
        Vehicle v = equality.getUserInput();
        if (!equality.vehicles.contains(v)) {
            equality.vehicles.add(v);
        }
        System.out.println("number of vehicles = " + equality.vehicles.size());
        System.out.println();

        Vehicle vehicle = equality.vehicles.get(0);
        System.out.println(vehicle);
        System.out.println("null comparison: " + vehicle.equals(null));
        System.out.println("String comparison: " + vehicle.equals("123"));
        System.out.println("same obj comparison: " + vehicle.equals(vehicle));
    }
}
