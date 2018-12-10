package com.example.attempt1;


import android.app.Activity;

public class ListBean extends Activity{
    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getConstrctr() {
        return constrctr;
    }

    public void setConstrctr(String constrctr) {
        this.constrctr = constrctr;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    private String price;
    private String location;
    private String type;
    private String constrctr;
    private String date;

}

