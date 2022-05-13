package com.m3.spring.example2;

import org.springframework.stereotype.Repository;

@Repository
public class LuckyNumberDBImpl implements LuckyNumberDB {
    @Override
    public void store(int i) {
    }

    @Override
    public int retrieve() {
        return 0;
    }
}
