package com.fhsu.redtrade.entity;

import javax.persistence.*;

@Entity
@Table(name = "holding")
public class Holding {


    private int id;
    private int shares;
    private String symbol;
    private int userId;


    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }



    public int getShares() {
        return shares;
    }

    public void setShares(int shares) {
        this.shares = shares;
    }



    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }



    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }



    @Override
    public String toString() {
        return "id=" + id + ", userId=" + userId;
    }
}
