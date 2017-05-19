package org.pember.sparkdemo.shared.pojo;

import java.io.Serializable;

public class Company implements Serializable{

    private String symbol;
    private String name;
    private String address;

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
