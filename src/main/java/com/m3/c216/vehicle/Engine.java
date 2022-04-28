package com.m3.c216.vehicle;

import java.util.Objects;

public class Engine {

    private final String type; // v8, v6, v4, 4cyl
    private final int cc;

    public Engine(String type, int cc) {
        this.type = type;
        this.cc = cc;
    }

    public int getCC() {
        return cc;
    }

    public String getType() {
        return type;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || !obj.getClass().equals(this.getClass()))
            return false;
        Engine e = (Engine) obj;
        return cc == e.cc && Objects.equals(type, e.type);
    }

    @Override
    public String toString() {
        return "Engine {type = " + type + " cc=" + cc + "}";
    }
}
