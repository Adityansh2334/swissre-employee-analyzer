package com.swissre.app.config;

public class SalaryConfig {
    private final double minMultiplier;
    private final double maxMultiplier;

    public SalaryConfig(int minPercentage, int maxPercentage) {
        if (minPercentage < 0 || maxPercentage < minPercentage) {
            throw new IllegalArgumentException("Invalid percentage range");
        }

        this.minMultiplier = 1 + (minPercentage / 100.0);
        this.maxMultiplier = 1 + (maxPercentage / 100.0);
    }

    public double getMinMultiplier() {
        return minMultiplier;
    }

    public double getMaxMultiplier() {
        return maxMultiplier;
    }
}
