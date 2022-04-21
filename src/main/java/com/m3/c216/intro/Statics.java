package com.m3.c216.intro;

public class Statics {

    private int i = 1;
    private double d = 3.14;
    private String s1 = "C216";

    private static String s2 = "m3";

    public int method0() {
        i++;
        d = 0;
        // s2 = s2;
        return 0;
    }

    public static void method1() {
        //i++;
        s2 = "m4";
    }

    public static void main(String[] args) {
        Statics statics1 = new Statics();
        Statics statics2 = new Statics();

        statics1.printout("statics1");
        statics2.printout("statics2");

        Statics.method1();
        statics1.method0();

        statics1.printout("statics1");
        statics2.printout("statics2");
    }

    public void printout(String user) {
        System.out.println(getFormattedString(user));
    }

    public String getFormattedString(String user) {
        return String.format("user=%s: i=%d d=%f s1=%s s2=%s %n", user, i, d, s1, s2);
    }
}
