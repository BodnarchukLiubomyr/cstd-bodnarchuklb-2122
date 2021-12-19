package com.company.model.entity.payment;

import com.company.model.entity.tariff.Tariff;

import java.math.BigDecimal;

public class Payment {
    private int tariffId;
    private int walletId;
    private BigDecimal price;
    private String tariffName;
    private int time;

    public int getTariffId() {
        return tariffId;
    }
    public void setTariffId(int tariffId) {
        this.tariffId = tariffId;
    }

    public int getWalletId() {
        return walletId;
    }
    public void setWalletId(int walletId) {
        this.walletId = walletId;
    }

    public BigDecimal getPrice() {
        return price;
    }
    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getTariffName() {
        return tariffName;
    }
    public void setTariffName(String tariffName) {
        this.tariffName = tariffName;
    }

    public int getTime() {
        return time;
    }
    public void setTime(int time) {
        this.time = time;
    }
}
