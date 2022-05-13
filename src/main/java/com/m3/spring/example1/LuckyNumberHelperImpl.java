package com.m3.spring.example1;

public class LuckyNumberHelperImpl implements LuckyNumberHelper {

    private final LuckyNumberService luckyNumberService;
    private final LuckyNumberDB luckyNumberDB;

    public LuckyNumberHelperImpl(LuckyNumberService luckyNumberService, LuckyNumberDB luckyNumberDB) {
        this.luckyNumberService = luckyNumberService;
        this.luckyNumberDB = luckyNumberDB;
    }

    public void showNumber() {
        int num = luckyNumberService.getNumber();
        System.out.println("Your lucky number is: " + num);
    }
}
