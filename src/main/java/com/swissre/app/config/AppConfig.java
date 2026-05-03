package com.swissre.app.config;

public class AppConfig {

    private final int minSalaryPercentage;
    private final int maxSalaryPercentage;
    private final int maxReportingDepth;

    public AppConfig(int minSalaryPercentage, int maxSalaryPercentage, int maxReportingDepth) {
        this.minSalaryPercentage = minSalaryPercentage;
        this.maxSalaryPercentage = maxSalaryPercentage;
        this.maxReportingDepth = maxReportingDepth;
    }

    public int getMinSalaryPercentage() {
        return minSalaryPercentage;
    }

    public int getMaxSalaryPercentage() {
        return maxSalaryPercentage;
    }

    public int getMaxReportingDepth() {
        return maxReportingDepth;
    }
}