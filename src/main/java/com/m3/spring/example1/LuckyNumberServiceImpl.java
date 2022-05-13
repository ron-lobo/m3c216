package com.m3.spring.example1;

import java.util.Random;

public class LuckyNumberServiceImpl implements LuckyNumberService {

    private DepA depA;
    private Random random = new Random();

    public LuckyNumberServiceImpl(DepA depA) {
        this.depA = depA;
    }

    @Override
    public int getNumber() {
        return random.nextInt(1000);
    }
}
