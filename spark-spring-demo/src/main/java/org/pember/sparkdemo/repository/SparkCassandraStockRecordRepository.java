package org.pember.sparkdemo.repository;

import org.apache.spark.api.java.JavaSparkContext;
import org.pember.sparkdemo.SparkspringdemoApplication;
import org.pember.sparkdemo.shared.pojo.DailyPriceRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.datastax.spark.connector.japi.CassandraJavaUtil.javaFunctions;
import static com.datastax.spark.connector.japi.CassandraJavaUtil.mapToRow;

@Service
public class SparkCassandraStockRecordRepository {
    private static Logger log = LoggerFactory.getLogger(SparkspringdemoApplication.class.getName());

    private String CASSANDRA_KEYSPACE;

    public SparkCassandraStockRecordRepository(String cassandraKeyspace) {
        this.CASSANDRA_KEYSPACE = cassandraKeyspace;
    }

    public void save(JavaSparkContext context, List<DailyPriceRecord> records) {
        javaFunctions(context.parallelize(records))
                .writerBuilder(CASSANDRA_KEYSPACE, "daily_price_record", mapToRow(DailyPriceRecord.class))
                .saveToCassandra();
    }


}
