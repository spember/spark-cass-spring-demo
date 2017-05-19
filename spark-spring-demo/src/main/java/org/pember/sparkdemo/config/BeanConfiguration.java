package org.pember.sparkdemo.config;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaSparkContext;
import org.pember.sparkdemo.SparkspringdemoApplication;
import org.pember.sparkdemo.repository.SparkCassandraStockRecordRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class BeanConfiguration {
    private static Logger log = LoggerFactory.getLogger(SparkspringdemoApplication.class.getName());

    @Value("${spark.master}")
    String sparkMasterUrl;

    @Value("${cassandra.connection.host}")
    String cassandraHost;

    @Value("${cassandra.keyspace}")
    String cassandraKeypsace;

    @Bean
    public JavaSparkContext javaSparkContext() {
        log.info("Connecting to spark with master Url: {}, and cassandra host: {}",
                sparkMasterUrl, cassandraHost);

        SparkConf conf = new SparkConf(true)
                .set("spark.cassandra.connection.host", cassandraHost)
                .set("spark.submit.deployMode", "client");

        JavaSparkContext context = new JavaSparkContext(
                sparkMasterUrl,
                "SparkDemo",
                conf
        );

        log.debug("SparkContext created");
        return context;
    }

    @Bean
    public SparkCassandraStockRecordRepository sparkCassandraStockRecordRepository() {
        return new SparkCassandraStockRecordRepository(cassandraKeypsace);
    }


}
