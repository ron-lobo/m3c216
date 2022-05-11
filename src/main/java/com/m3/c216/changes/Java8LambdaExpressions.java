package com.m3.c216.changes;

import static com.m3.c216.changes.Utils.print;
import static com.m3.c216.changes.Utils.printMethod;

public class Java8LambdaExpressions {

    public static final String INTRO_NAME = "Hi, I am";
    public static final String AND = "and";
    public static final String INTRO_JOB = "I am a";

    public static void main(String[] args) {
        printMethod("Features Introduced in Java 8: LambdaExpressions");
        Java8LambdaExpressions j8 = new Java8LambdaExpressions();
        j8.lambdaExpressions();
    }


    @FunctionalInterface
    private interface Intro0 {
        void introduce();
    }

    @FunctionalInterface
    private interface Intro1 {
        String introduce(String name);
    }

    //	@FunctionalInterface
    private interface Intro2 {
        String introduce(String name, String job);
    }


    private class MyIntro2 implements Intro2 {
        public String introduce(String name, String job) {
            return print(INTRO_NAME, name, AND, INTRO_JOB, job);
        }
    }


    private void lambdaExpressions() {
        printMethod("lambdaExpressions");

        Intro2 objA = new MyIntro2();

        Intro2 objB = new Intro2() {
            @Override
            public String introduce(String name, String job) {
                return print(INTRO_NAME, name, AND, INTRO_JOB, job);
            }
        };


        Intro2 lambdaA1 = (String name, String job) -> {
            return print(INTRO_NAME, name, AND, INTRO_JOB, job);
        };


        Intro2 lambdaA2 = (name, job) -> {
            return print(INTRO_NAME, name, AND, INTRO_JOB, job);
        };


        Intro2 lambdaA3 = (name, job) -> print(INTRO_NAME, name, AND, INTRO_JOB, job);


        Intro1 lambdaB = name -> print(INTRO_NAME, name);


        Intro0 lambdaC = () -> print(INTRO_NAME, "Anon E Moose");


        // let's try using them:
        objA.introduce("Liz", "queen");
        objB.introduce("Florence", "machine");

        lambdaA1.introduce("Francis", "pope");
        lambdaA2.introduce("Donald", "dope");
        lambdaA3.introduce("Justin", "chanteuse");

        lambdaB.introduce("Kim");
        lambdaC.introduce();
    }
}
