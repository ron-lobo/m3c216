package com.m3.c216.lombok;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
//@EqualsAndHashCode
public class Trade1 {

    private final int id;

    @Getter
    private String side;
    private int qty;
    private String symbol;
    private BigDecimal price;
    private String customer;
    private String dealer;
    private boolean isExecuted;
    private boolean isActive;
    private LocalDateTime orderDateTime;
    private LocalDateTime executionDateTime;

//    public String getDealer() {
//        return "dealer 1";
//    }

    public static void main(String[] args) {
        Trade1 trade1 = new Trade1(1);
        System.out.println(trade1);
    }
}
