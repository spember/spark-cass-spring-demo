package org.pember.sparkdemo.shared.pojo;

import java.io.Serializable;

/**
 * Meant to hold a subset of the information with Company and DailyPriceRecord, used for calculations
 */
public class RecordValueContext implements Serializable {
    private String symbol;
    private String companyName;
    private Double value;
    private Integer shareVolume;

    public RecordValueContext(String symbol, String companyName, Double value, Integer shareVolume) {
        this.symbol = symbol;
        this.companyName = companyName;
        this.value = value;
        this.shareVolume = shareVolume;
    }

    public String getSymbol() {
        return symbol;
    }

    public String getCompanyName() {
        return companyName;
    }

    public Double getValue() {
        return value;
    }

    public Integer getShareVolume() {
        return shareVolume;
    }
}
