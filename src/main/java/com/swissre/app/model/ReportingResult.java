package com.swissre.app.model;

/*
* ReportingResult class is responsible for storing the reporting analysis results and print into console
*/
public class ReportingResult {

    private String employeeName;
    private int maxReportingChain;
    private int longReportingChain;

    public ReportingResult(String employeeName, int maxReportingChain, int longReportingChain) {
        this.employeeName = employeeName;
        this.maxReportingChain = maxReportingChain;
        this.longReportingChain = longReportingChain;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public int getLongReportingChain() {
        return longReportingChain;
    }

    public void setLongReportingChain(int longReportingChain) {
        this.longReportingChain = longReportingChain;
    }

    public int getMaxReportingChain() {
        return maxReportingChain;
    }

    public void setMaxReportingChain(int maxReportingChain) {
        this.maxReportingChain = maxReportingChain;
    }
}
