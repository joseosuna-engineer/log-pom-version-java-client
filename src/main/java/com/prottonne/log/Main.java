package com.prottonne.log;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

@SpringBootApplication
public class Main {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @EventListener
    public void onStartup(ApplicationReadyEvent event) {

        Package mainPackage = Main.class.getPackage();
        String version = mainPackage.getImplementationVersion();

        logger.info("DEPLOYMENT-VERSION={}", version);
    }

}
