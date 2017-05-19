package org.pember.sparkdemo.service;

import org.apache.spark.api.java.JavaSparkContext;
import org.pember.sparkdemo.shared.pojo.DailyPriceRecord;
import org.pember.sparkdemo.repository.SparkCassandraStockRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Effectively a wrapper around the repository, it's main purpose is to have the {@link JavaSparkContext} autowired into it, then passed at
 * run time to the underlying repository for querying.
 * The reason for this? The service wrapping your spark calls appears to be serialized and transferred along with the code that actually gets executed
 * Spring @Autowired doesn't seem to play nice with this; the actual class likely gets transferred and executed outside
 * of the Spring lifecycle, so the field would not be populated.
 *
 * The same goes for any autowired fields. Configuration '@Value's, too.
 *
 */
@Service
public class SparkCassandraRecordService {


    private JavaSparkContext javaSparkContext;
    private SparkCassandraStockRecordRepository recordRepository;


    @Autowired public SparkCassandraRecordService(JavaSparkContext javaSparkContext, SparkCassandraStockRecordRepository recordRepository) {
        this.javaSparkContext = javaSparkContext;
        this.recordRepository = recordRepository;
    }

    public void save(List<DailyPriceRecord> records) {
        recordRepository.save(javaSparkContext, records);
    }
}
