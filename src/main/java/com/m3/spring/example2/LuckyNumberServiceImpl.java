package com.m3.spring.example2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class LuckyNumberServiceImpl implements LuckyNumberService {

    private DepA depA;
    private Random random = new Random();

    @Autowired
    public LuckyNumberServiceImpl(DepA depA) {
        this.depA = depA;
    }

    public LuckyNumberServiceImpl(DepA depA, Random random) {
        this.depA = depA;
        this.random = random;
    }

    @Override
    public int getNumber() {
        depA.method1();
        return random.nextInt(1000);
    }
}
