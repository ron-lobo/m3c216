package com.m3.c216.enums;

import java.time.LocalDate;
import java.time.Month;

public enum Season {

    SPRING(Month.MARCH),
    SUMMER(Month.JUNE),
    AUTUMN(Month.SEPTEMBER, "Fall"),
    WINTER(Month.DECEMBER);

    private Month month;
    private String altName;

    Season(Month month) {
        this.month = month;
    }

    Season(Month month, String altName) {
        this.month = month;
        this.altName = altName;
    }

    public Month getMonth() {
        return month;
    }

    public LocalDate getStartDate() {
        int year = LocalDate.now().getYear();
        return LocalDate.of(year, this.month, 21);
    }

    public LocalDate getNextStartDate() {
        LocalDate d = getStartDate();
        if (d.isBefore(LocalDate.now())) {
            d = LocalDate.of(d.getYear() + 1, d.getMonth(), d.getDayOfMonth());
        }
        return d;
    }

    public static Season getSeason_v1(String str) {
        try {
            return valueOf(str.toUpperCase());
        } catch (Exception e) {
            return null;
        }
    }

    public static Season getSeason(String str) {
        for (Season s : values()) {
            if (s.toString().equalsIgnoreCase(str) ||
                    (s.altName != null && s.altName.equalsIgnoreCase(str))) {
                return s;
            }
        }
        return null;
    }

    public String toString() {
        return name().charAt(0) + name().substring(1).toLowerCase();
    }
}
