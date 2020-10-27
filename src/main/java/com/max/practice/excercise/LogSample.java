package com.max.practice.excercise;


import org.apache.log4j.MDC;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogSample {
    private static final Logger LOG = LoggerFactory.getLogger(LogSample.class);

    public static void main(String[] args) {
        MDC.put("id", "2314");
        LOG.info("this is info log message");
    }
}
