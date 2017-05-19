package org.pember.sparkdemo.shared.pojo;

import org.apache.commons.lang3.time.DateUtils;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

public class DailyPriceRecord implements Serializable {
    private String symbol;


    private Date recordedDate;
    private double value;
    private double previousValue;
    private double valueChange;
    private double percentChange;
    private int shareVolume;

    private int year;
    private int month;
    private int day;

    public DailyPriceRecord() {
    }

    public static DailyPriceRecord buildFromFileRow(String fileRow) {
        String[] tokens = fileRow.split("\\|");
        assert tokens.length == 7;
        DailyPriceRecord record = new DailyPriceRecord();

        record.setSymbol(tokens[0]);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            record.setRecordedDate(dateFormat.parse(tokens[1]));
            Calendar cal = DateUtils.toCalendar(record.getRecordedDate());
            record.setYear(cal.get(Calendar.YEAR));
            record.setMonth(cal.get(Calendar.MONTH));
            record.setDay(cal.get(Calendar.DAY_OF_MONTH));


        } catch (ParseException e) {
            e.printStackTrace();
        }

        record.setValue(Double.parseDouble(tokens[2]));
        record.setPreviousValue(Double.parseDouble(tokens[3]));
        record.setValueChange(Double.parseDouble(tokens[4]));
        record.setPercentChange(Double.parseDouble(tokens[5]));
        record.setShareVolume(Integer.parseInt(tokens[6]));
        return record;
    }

    public LocalDate getDate() {
        return LocalDate.of(this.year, this.month+1, this.day);
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public Date getRecordedDate() {
        return recordedDate;
    }

    public void setRecordedDate(Date recordedDate) {
        this.recordedDate = recordedDate;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public double getPreviousValue() {
        return previousValue;
    }

    public void setPreviousValue(double previousValue) {
        this.previousValue = previousValue;
    }

    public double getValueChange() {
        return valueChange;
    }

    public void setValueChange(double valueChange) {
        this.valueChange = valueChange;
    }

    public double getPercentChange() {
        return percentChange;
    }

    public void setPercentChange(double percentChange) {
        this.percentChange = percentChange;
    }

    public int getShareVolume() {
        return shareVolume;
    }

    public void setShareVolume(int shareVolume) {
        this.shareVolume = shareVolume;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }
}
