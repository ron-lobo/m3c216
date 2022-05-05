package com.m3.c216.enums;

public class Seasonality {

    public static void main(String[] args) {
        Seasonality seasonality = new Seasonality();
        seasonality.useSeasons();
        seasonality.findSeasons();
    }

    private void useSeasons() {

        for (Season season : Season.values()) {
            System.out.printf("season=%s starts in  %s %n", season, season.getMonth());
            System.out.printf("  start date = %s %n", season.getNextStartDate());
        }
    }

    private void findSeasons() {
        showSeason("SUMMER");
        showSeason("Winter");
        showSeason("Autum");
        showSeason(null);
        showSeason("Fall");
    }

    private void showSeason(String str) {
        Season s = Season.getSeason(str);
        if (s == null) {
            System.out.println("Season NOT FOUND!  " + str);
        } else {
            System.out.println("s = " + s + " starting on " + s.getNextStartDate());
        }
    }
}
