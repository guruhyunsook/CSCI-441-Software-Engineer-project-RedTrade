package com.fhsu.redtrade.entity;

import javax.persistence.*;

@Entity
@Table(name = "stock")
public class Stock {

    private String symbol;
    private String company;
    private String link;
    private float currentPrice;

    @Id
    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }


    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }


    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }


    public float getCurrentPrice() {
        return currentPrice;
    }

    public void setCurrentPrice(float currentPrice) {
        this.currentPrice = currentPrice;
    }



    @Override
    public String toString() {
        return "symbol=" + symbol;
    }
}
