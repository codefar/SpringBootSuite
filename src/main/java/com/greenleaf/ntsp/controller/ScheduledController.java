package com.greenleaf.ntsp.controller;

import com.greenleaf.ntsp.service.ScheduledServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Component
public class ScheduledController {

    static final Logger logger = LoggerFactory.getLogger(ScheduledController.class);

    @Autowired
    ScheduledServiceImpl scheduledService;

    @Scheduled(cron = "0 0 0 * * ?")
    public void pushDataScheduled() throws Exception {
        logger.info("start push data scheduled!");
        scheduledService.pushData();
        logger.info("end push data scheduled!");
    }
}