package com.designpatterns.singleton;

public class Logger {
    // 1. Create a private static instance of itself[cite: 1]
    private static Logger instance;

    // 2. Ensure the constructor is private so no other class can instantiate it[cite: 1]
    private Logger() {
        // Private constructor
    }

    // 3. Provide a public static method to get the single instance[cite: 1]
    public static synchronized Logger getInstance() {
        if (instance == null) {
            instance = new Logger();
        }
        return instance;
    }

    // A sample logging utility method
    public void log(String message) {
        System.out.println("[LOG]: " + message);
    }
}