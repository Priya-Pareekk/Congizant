package com.designpatterns.singleton;

public class SingletonTest {
    public static void main(String[] args) {
        // Try to get two separate instances of the Logger class[cite: 1]
        Logger logger1 = Logger.getInstance();
        Logger logger2 = Logger.getInstance();

        // Log messages using both instances
        logger1.log("This is an event message logged by logger1.");
        logger2.log("This is another event message logged by logger2.");

        // Verify that both references point to the exact same memory instance[cite: 1]
        System.out.println("\n--- Verification ---");
        System.out.println("Logger 1 HashCode: " + logger1.hashCode());
        System.out.println("Logger 2 HashCode: " + logger2.hashCode());

        if (logger1 == logger2) {
            System.out.println("SUCCESS: Both variables reference the same unique Logger instance. Singleton Pattern works!");
        } else {
            System.out.println("FAILURE: Different instances exist.");
        }
    }
}