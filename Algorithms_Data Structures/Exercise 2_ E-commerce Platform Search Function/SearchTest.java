package com.algorithms.search;

import java.util.Arrays;

public class SearchTest {
    public static void main(String[] args) {
        // Create an array of products
        Product[] products = {
            new Product(101, "Wireless Mouse", "Electronics"),
            new Product(105, "Mechanical Keyboard", "Electronics"),
            new Product(112, "Gaming Monitor", "Electronics"),
            new Product(120, "Leather Wallet", "Accessories"),
            new Product(135, "Running Shoes", "Footwear")
        };

        // Note: The array must be sorted by productId for Binary Search to work properly
        int targetId = 120;

        System.out.println("--- Testing Linear Search ---");
        Product resultLinear = SearchAlgorithms.linearSearch(products, targetId);
        System.out.println("Result: " + (resultLinear != null ? resultLinear : "Product Not Found"));

        System.out.println("\n--- Testing Binary Search ---");
        Product resultBinary = SearchAlgorithms.binarySearch(products, targetId);
        System.out.println("Result: " + (resultBinary != null ? resultBinary : "Product Not Found"));
    }
}