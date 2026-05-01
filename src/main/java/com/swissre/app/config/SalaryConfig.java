package com.swissre.app.config;

public record SalaryConfig(double minMultiplier, double maxMultiplier) {
    public SalaryConfig(int minPercentage, int maxPercentage) {
        this(1 + (minPercentage / 100.0), 1 + (maxPercentage / 100.0));
        
        if (minPercentage < 0 || maxPercentage < minPercentage) {
            throw new IllegalArgumentException("Invalid percentage range");
        }
    }
}
