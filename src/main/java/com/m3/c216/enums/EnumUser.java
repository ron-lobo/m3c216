package com.m3.c216.enums;

import java.util.ArrayList;
import java.util.List;

public class EnumUser {

    private List<String> maleEnrollees = new ArrayList<>();
    private List<String> femaleEnrollees = new ArrayList<>();
    private List<String> otherEnrollees = new ArrayList<>();

    public static void main(String[] args) {
        EnumUser eu = new EnumUser();
        eu.testGender();
    }

    private void testGender() {
        Gender g1 = Gender.MALE;
        Gender g2 = Gender.FEMALE;

        enroll("Chris", Gender.FEMALE);
        enroll("Francis", Gender.MALE);
        enroll("Michael", Gender.FEMALE);
        enroll("Nobby", Gender.DONT_KNOW);
    }

    private void enroll(String name, Gender g) {
        if (g == Gender.MALE) {
            maleEnrollees.add(name);
        } else {
            femaleEnrollees.add(name);
        }
        System.out.println("enrollee added to roster");
    }

    private void enroll_v2(String name, Gender g) {
        switch (g) {
            case MALE:
                maleEnrollees.add(name);
                break;
            case FEMALE:
                femaleEnrollees.add(name);
                break;
            case DONT_KNOW:
                otherEnrollees.add(name);
                break;
        }
        System.out.println("enrollee added to roster");
    }

}
