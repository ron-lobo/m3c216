package com.m3.c216.intro;

public class Finals {

    public static void main(String[] args) {
        Statics statics1 = new Statics();
        statics1.method0();
        // statics1.method1();      // warning
        Statics.method1();
        // statics1.printout();     // error
    }
}
