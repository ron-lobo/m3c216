package com.m3.c216.intro;

import com.m3.c216.vehicle.Engine;

import java.util.Comparator;

class MyEngineComparator implements Comparator<Engine> {

    @Override
    public int compare(Engine e1, Engine e2) {
        int result = Integer.compare(e1.getNumCylinders(), e2.getNumCylinders());
        if (result == 0) {
            result = Integer.compare(e1.getCC(), e2.getCC());
        }
        return result;
    }
}
