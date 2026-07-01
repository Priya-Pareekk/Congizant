package com.algorithms.forecasting;

public class FinancialForecasting {

    /**
     * Recursive method to calculate the future value.
     * Formula: Future Value = Present Value * (1 + growthRate)^years
     * * @param presentValue Current financial value
     * @param growthRate Constant annual growth rate (e.g., 0.05 for 5%)
     * @param years Number of years into the future to forecast
     * @return Predicted future value
     */
    public static double calculateFutureValue(double presentValue, double growthRate, int years) {
        // Base Case: If years is 0, the value remains the present value
        if (years == 0) {
            return presentValue;
        }
        
        // Recursive Case: Calculate value for (years - 1) and apply growth for the current year
        return calculateFutureValue(presentValue, growthRate, years - 1) * (1 + growthRate);
    }
}