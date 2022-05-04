package com.m3.c216.vehicle;

import java.util.Objects;

public class Engine implements Comparable<Engine> {

    private final String style;
    private final int numCylinders;
    private final int cc;
    private final String type; // v8, v6, v4, 4cyl

    public Engine(String style, int numCylinders, int cc) {
        this.numCylinders = numCylinders;
        this.style = style;
        this.cc = cc;
        this.type = style + numCylinders;
    }

    public Engine(String type, int cc) {
        this.type = type;
        this.cc = cc;
        this.numCylinders = 4;
        this.style = "V";
    }

    public int getCC() {
        return cc;
    }

    public String getType() {
        return type;
    }

    public int getNumCylinders() {
        return numCylinders;
    }

    public String getStyle() {
        return style;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || !obj.getClass().equals(this.getClass()))
            return false;
        Engine e = (Engine) obj;
        return cc == e.cc && Objects.equals(type, e.type);
    }

    public int hashCode_v1() {
        return 0;
    }

    public int hashCode_v2() {
        return cc + type.hashCode();
    }

    public int hashCode_v3() {
        final int PRIME = 29;
        int result = ((Integer) cc).hashCode();
        result = result * PRIME + type.hashCode();
        return result;
    }

    public int hashCode() {
        return Objects.hash(cc, type);
    }

    @Override
    public String toString() {
        return "Engine {type = " + type + " cc=" + cc + "}";
    }

    @Override
    public int compareTo(Engine e) {
        return Integer.compare(cc, e.cc);
    }
}
