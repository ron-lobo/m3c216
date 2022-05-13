package com.m3.spring.example1;

public class LuckyNumberServer {

    private final LuckyNumberHelper luckyNumberHelper;

    public LuckyNumberServer(LuckyNumberHelper luckyNumberHelper) {
        this.luckyNumberHelper = luckyNumberHelper;
    }

    public void createLuckyNumber() {
        luckyNumberHelper.showNumber();
    }

    public static void main(String[] args) {
        DepAImpl depA = new DepAImpl();
        LuckyNumberServiceImpl luckyNumberService = new LuckyNumberServiceImpl(depA);
        LuckyNumberDBImpl luckyNumberDB = new LuckyNumberDBImpl();
        LuckyNumberHelperImpl luckyNumberHelper = new LuckyNumberHelperImpl(luckyNumberService, luckyNumberDB);
        LuckyNumberServer luckyNumberServer = new LuckyNumberServer(luckyNumberHelper);
        luckyNumberServer.createLuckyNumber();
    }
}



