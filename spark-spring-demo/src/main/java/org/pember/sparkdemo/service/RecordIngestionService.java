package org.pember.sparkdemo.service;

import org.pember.sparkdemo.SparkspringdemoApplication;
import org.pember.sparkdemo.shared.pojo.DailyPriceRecord;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RecordIngestionService {
    private static Logger log = LoggerFactory.getLogger(SparkspringdemoApplication.class.getName());

    private SparkCassandraRecordService recordService;

    public RecordIngestionService(SparkCassandraRecordService recordService) {
        this.recordService = recordService;
    }

    public void ingestFromCsv(String filename) {
        List<DailyPriceRecord> lines = new ArrayList<>();

        try {
            log.info("URI = {}", ClassLoader.getSystemResource(filename).toURI());

            lines = Files.lines(Paths.get(ClassLoader.getSystemResource(filename).toURI()))

            .map(DailyPriceRecord::buildFromFileRow)
            .collect(Collectors.toList());

            log.info("Received {} lines", lines.size());
            recordService.save(lines);


        } catch (IOException e) {
            log.error("Could not find file {}", filename, e);
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }
}
