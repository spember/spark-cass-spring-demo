package org.pember.sparkdemo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SparkspringdemoApplication {
	private static Logger log = LoggerFactory.getLogger(SparkspringdemoApplication.class.getName());

	public static void main(String[] args) {
		log.info("Starting up");
		SpringApplication.run(SparkspringdemoApplication.class, args);
	}
}
