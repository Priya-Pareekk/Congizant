package com.algorithms.search;

public class SearchAlgorithms {

    // Linear Search Implementation
    public static Product linearSearch(Product[] products, int targetId) {
        for (Product product : products) {
            if (product.getProductId() == targetId) {
                return product; // Found
            }
        }
        return null; // Not found
    }

    // Binary Search Implementation (Assumes array is sorted by productId)
    public static Product binarySearch(Product[] products, int targetId) {
        int left = 0;
        int right = products.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            if (products[mid].getProductId() == targetId) {
                return products[mid]; // Found
            }
            
            if (products[mid].getProductId() < targetId) {
                left = mid + 1; // Search right half
            } else {
                right = mid - 1; // Search left half
            }
        }
        return null; // Not found
    }
}