package com.m3.c216.intro;

public class Primitives {

    public static void main(String[] args) {

        method1();

        int i0 = 5;
        Integer i1 = 6;

        // autoboxing
        i1 = i0;
        i0 = i1;

        System.out.print("i0=" + i0);
        System.out.print("i1=" + i1);
        System.out.println();

        System.out.println("i0=" + i0);
        System.out.println("i1=" + i1 + ", doubleVal=" + i1.doubleValue());
        System.out.println(i1);

        i0 = i0 + 1;
        i0 += 1;
        i0++;

        i1++;
        i1 = i0;
        i0--;
        System.out.printf("i0=%d, i1=%d%n", i0, i1);

        Integer i2 = method2(i0, i1);
        int i3 = method2(i1, i0);
        System.out.printf("i2=%d, i3=%d%n", i2, i3);
    }

    static Integer method2(int a, Integer b) {
        return a + b;
    }

    private static void method1() {
        // primitives
        byte by;        // 8  bits = 1 byte;    range: -128 .. 127
        short s;        // 16 bits = 2 bytes;   range: -32768 .. 32767
        int i;          // 32 bits = 4 bytes;   range: -2.1B .. 2.1B
        long l;         // 64 bits = 8 bytes;   (+/- 10^19)

        float f;        // 32 bits
        double d;       // 64 bits

        char c;

        boolean b;

        // wrapper classes
        Byte by2;
        Short s2;
        Integer i2;
        Long l2;
        Float f2;
        Double d2;
        Character c2;
        Boolean b2;
    }
}
