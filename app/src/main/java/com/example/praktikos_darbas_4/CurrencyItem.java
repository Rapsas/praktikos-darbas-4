package com.example.praktikos_darbas_4;

public class CurrencyItem {
    private String currency;
    private double rate;

    public CurrencyItem(String currency, double rate) {
        this.currency = currency;
        this.rate = rate;
    }

    public String getCurrency() {
        return currency;
    }

    public double getRate() {
        return rate;
    }

    @Override
    public String toString() {
        return "Currency: " + currency + ". Rate: " + rate;
    }
}

