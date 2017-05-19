package org.pember.sparkdemo.shared.pojo;

import java.io.Serializable;
import java.time.LocalDate;

public class StockQuery implements Serializable {
    private String symbol;
    private LocalDate start;

    public StockQuery(String symbol, LocalDate start) {
        this.symbol = symbol;
        this.start = start;
    }

    public StockQuery(LocalDate start) {
        this.start = start;
    }

    public String getSymbol() {
        return symbol;
    }

    public LocalDate getStart() {
        return start;
    }
}
