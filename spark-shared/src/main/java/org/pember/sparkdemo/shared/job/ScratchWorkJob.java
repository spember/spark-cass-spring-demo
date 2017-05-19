package org.pember.sparkdemo.shared.job;

import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.pember.sparkdemo.shared.pojo.DailyPriceRecord;
import org.pember.sparkdemo.shared.pojo.StockOverview;

import java.util.Calendar;

import static com.datastax.spark.connector.japi.CassandraJavaUtil.javaFunctions;
import static com.datastax.spark.connector.japi.CassandraJavaUtil.mapRowTo;

public class ScratchWorkJob {
//
//    public StockOverview execute(JavaSparkContext context, String query) {
//
//        JavaRDD<DailyPriceRecord> symbolResults = grabRawRecords(context, query);
//
//        JavaRDD<Double> symbolValues = symbolResults
//                .map(DailyPriceRecord::getValue);
//
//        Double maxValue = symbolValues.reduce(
//                (value1, value2) -> value1 > value2 ? value1 : value2
//        );
//
//        System.out.println("Max value is " + maxValue);
//
//
//        return null;
//    }
//
//
//    private JavaRDD<DailyPriceRecord> grabRawRecords(JavaSparkContext context, String symbol) {
//
//        javaFunctions(context)
//                .cassandraTable("stock_data", "daily_price_record", mapRowTo(DailyPriceRecord.class))
//                //.where("symbol = ? and year = ? and month >= ? and day >= ?", symbol, target.get(Calendar.YEAR), target.get(Calendar.MONTH), target.get(Calendar.DAY_OF_MONTH))
//                .where("symbol = ? and year = ? and day >= ?", symbol, 2017, target.get(Calendar.DAY_OF_MONTH))
//    }
}
