package com.m3.spring.example2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class LuckyNumberHelperImpl implements LuckyNumberHelper {

    private LuckyNumberService luckyNumberService;

    @Autowired
    private LuckyNumberDB luckyNumberDB;

//    public LuckyNumberHelperImpl(LuckyNumberService luckyNumberService, LuckyNumberDB luckyNumberDB) {
//        this.luckyNumberService = luckyNumberService;
//        this.luckyNumberDB = luckyNumberDB;
//    }

    @Autowired
    public void setLuckyNumberService(LuckyNumberService luckyNumberService) {
        this.luckyNumberService = luckyNumberService;
    }

    public void showNumber() {
        int num = luckyNumberService.getNumber();
        System.out.println("Your lucky number is: " + num);
    }
}
