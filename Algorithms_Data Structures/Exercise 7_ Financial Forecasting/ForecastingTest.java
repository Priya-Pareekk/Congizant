package com.algorithms.forecasting;

public class ForecastingTest {
    public static void main(String[] args) {
        double initialInvestment = 1000.0; // Starting value ($1000)
        double annualGrowthRate = 0.05;    // 5% constant growth rate
        int forecastYears = 5;             // Predict 5 years into the future

        System.out.println("--- Financial Forecasting Tool ---");
        System.out.println("Initial Value: " + initialInvestment);
        System.out.println("Annual Growth Rate: " + (annualGrowthRate * 100) + "%");
        System.out.println("Forecasting Period: " + forecastYears + " years\n");

        // Calculate predicted value using recursion
        double futureValue = FinancialForecasting.calculateFutureValue(initialInvestment, annualGrowthRate, forecastYears);

        // Display results formatted to 2 decimal places
        System.out.printf("Predicted Future Value after %d years: %.2f\n", forecastYears, futureValue);
    }
}