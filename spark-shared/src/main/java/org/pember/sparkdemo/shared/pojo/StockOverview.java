package org.pember.sparkdemo.shared.pojo;

import java.io.Serializable;

/**
 *
 */
public class StockOverview implements Serializable {
    private String symbol;
    private String companyName;
    private Double thirtyDayLow;
    private Double thirtyDayHigh;
    private Integer thirtyDayAverageVolume;


    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public Double getThirtyDayLow() {
        return thirtyDayLow;
    }

    public void setThirtyDayLow(Double thirtyDayLow) {
        this.thirtyDayLow = thirtyDayLow;
    }

    public Double getThirtyDayHigh() {
        return thirtyDayHigh;
    }

    public void setThirtyDayHigh(Double thirtyDayHigh) {
        this.thirtyDayHigh = thirtyDayHigh;
    }

    public Integer getThirtyDayAverageVolume() {
        return thirtyDayAverageVolume;
    }

    public void setThirtyDayAverageVolume(Integer thirtyDayAverageVolume) {
        this.thirtyDayAverageVolume = thirtyDayAverageVolume;
    }

    public String toString() {
        return symbol +" 30 day low: " + getThirtyDayLow() +", high: " + getThirtyDayHigh() +" avg volume: " + getThirtyDayAverageVolume();
    }
}
