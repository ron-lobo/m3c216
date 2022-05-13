package com.m3.spring.example1;

public interface LuckyNumberDB {
    void store(int i);

    int retrieve();
}
