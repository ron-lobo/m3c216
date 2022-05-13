package com.m3.spring.example2;

public interface LuckyNumberDB {
    void store(int i);

    int retrieve();
}
