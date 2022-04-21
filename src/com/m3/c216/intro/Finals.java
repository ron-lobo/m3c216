package com.m3.c216.intro;

public class Finals {

    private final int i = 123;
    private final Statics staticsA = new Statics();
    private Statics staticsB = new Statics();

    public static void main(String[] args) {
        Finals finals = new Finals();
        finals.method1();
        finals.method2();
    }

    private void method2() {
        System.out.printf("i=%d, %s", i, staticsA.getFormattedString("staticsA"));
        staticsA.method0();
        System.out.printf("i=%d, %s", i, staticsA.getFormattedString("staticsA"));
        // i = 4;
        // staticsA = staticsB;
        System.out.printf("i=%d, %s", i, staticsA.getFormattedString("staticsA"));
    }

    private void method1() {
        Statics statics1 = new Statics();
        statics1.method0();
        // statics1.method1();      // warning
        Statics.method1();
        // statics1.printout();     // error
    }
}
