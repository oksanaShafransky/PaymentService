package com.payment.service.dto.utils;

public enum CurrencyList {
    USD("American Dollar"),
    EUR("European"),
    ILS("Israeli Shekel"),
    GBP("Great Britain Pound"),
    CHY("Chaina Yuan"),
    RUB("Russian Rubl");

    private String currency;

    CurrencyList(String currency) {
        this.currency = currency;
    }

    public String getCurrency() {
        return currency;
    }
}
