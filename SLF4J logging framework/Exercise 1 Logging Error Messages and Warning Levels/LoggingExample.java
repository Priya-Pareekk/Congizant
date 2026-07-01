package com.logging.basics;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggingExample {
    // Initialize the logger instance tied to this specific class
    private static final Logger logger = LoggerFactory.getLogger(LoggingExample.class);

    public static void main(String[] args) {
        System.out.println("--- Executing SLF4J Logging Application ---");
        
        // Log an error message level entry
        logger.error("This is an error message");
        
        // Log a warning message level entry
        logger.warn("This is a warning message");
        
        System.out.println("--- Logging Completed Successfully ---");
    }
}