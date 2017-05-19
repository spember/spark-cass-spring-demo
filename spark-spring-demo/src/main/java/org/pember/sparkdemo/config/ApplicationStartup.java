package org.pember.sparkdemo.config;

import org.pember.sparkdemo.SparkspringdemoApplication;
import org.pember.sparkdemo.service.RecordIngestionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class ApplicationStartup implements ApplicationListener<ContextRefreshedEvent> {
    private static Logger log = LoggerFactory.getLogger(SparkspringdemoApplication.class.getName());

    private RecordIngestionService recordIngestionService;

    public ApplicationStartup(RecordIngestionService recordIngestionService) {
        this.recordIngestionService = recordIngestionService;
    }



    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        log.info("Time to ingest");
        recordIngestionService.ingestFromCsv("ticker.csv");
    }
}
