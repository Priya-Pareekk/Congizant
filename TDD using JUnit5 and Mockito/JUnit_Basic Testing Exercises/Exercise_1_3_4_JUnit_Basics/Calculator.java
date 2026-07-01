package com.junit.basics;

public class Calculator {
    public int add(int a, int b) {
        return a + b;
    }
    
    public int subtract(int a, int b) {
        return a - b;
    }
    
    public Object getObjectInstance(boolean returnNull) {
        return returnNull ? null : new Object();
    }
}