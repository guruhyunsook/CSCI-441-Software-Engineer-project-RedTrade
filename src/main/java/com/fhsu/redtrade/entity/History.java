package com.fhsu.redtrade.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "history")
public class History {


    private int id;
    private Date date;
    private String action;
    private String symbol;
    private int shares;
    private float price;
    private int userId;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }


    public String getAction() {
        return action;
    }


    public void setAction(String action) {
        this.action = action;
    }


    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }


    public int getShares() {
        return shares;
    }

    public void setShares(int shares) {
        this.shares = shares;
    }


    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
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
