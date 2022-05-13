package com.m3.c216.lombok;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

public class Trade {

    private final int id;
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

    public Trade(int id, String side, int qty, String symbol, BigDecimal price, String customer, String dealer, LocalDateTime orderDateTime) {
        this.id = id;
        this.side = side;
        this.qty = qty;
        this.symbol = symbol;
        this.price = price;
        this.customer = customer;
        this.dealer = dealer;
        this.orderDateTime = orderDateTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Trade trade = (Trade) o;
        return id == trade.id &&
                qty == trade.qty &&
                isExecuted == trade.isExecuted &&
                isActive == trade.isActive &&
                Objects.equals(side, trade.side) &&
                Objects.equals(symbol, trade.symbol) &&
                Objects.equals(price, trade.price) &&
                Objects.equals(customer, trade.customer) &&
                Objects.equals(dealer, trade.dealer) &&
                Objects.equals(orderDateTime, trade.orderDateTime) &&
                Objects.equals(executionDateTime, trade.executionDateTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, side, qty, symbol, price, customer, dealer, isExecuted, isActive, orderDateTime, executionDateTime);
    }

    @Override
    public String toString() {
        return "Trade{" +
                "id=" + id +
                ", side='" + side + '\'' +
                ", qty=" + qty +
                ", symbol='" + symbol + '\'' +
                ", price=" + price +
                ", customer='" + customer + '\'' +
                ", dealer='" + dealer + '\'' +
                ", isExecuted=" + isExecuted +
                ", isActive=" + isActive +
                ", orderDateTime=" + orderDateTime +
                ", executionDateTime=" + executionDateTime +
                '}';
    }

    public int getId() {
        return id;
    }

    public String getSide() {
        return side;
    }

    public void setSide(String side) {
        this.side = side;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public String getDealer() {
        return dealer;
    }

    public void setDealer(String dealer) {
        this.dealer = dealer;
    }

    public boolean isExecuted() {
        return isExecuted;
    }

    public void setExecuted(boolean executed) {
        isExecuted = executed;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public LocalDateTime getOrderDateTime() {
        return orderDateTime;
    }

    public void setOrderDateTime(LocalDateTime orderDateTime) {
        this.orderDateTime = orderDateTime;
    }

    public LocalDateTime getExecutionDateTime() {
        return executionDateTime;
    }

    public void setExecutionDateTime(LocalDateTime executionDateTime) {
        this.executionDateTime = executionDateTime;
    }
}
