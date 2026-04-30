package com.swissre.app.service;

import com.swissre.app.model.Employee;
import com.swissre.app.model.ReportingResult;

import java.util.ArrayList;
import java.util.List;

/*
* ReportingAnalyzer class is responsible for analyzing the reporting structure of employees
*/
public class ReportingAnalyzer {

    public List<ReportingResult> analyzeReporting(Employee emp, int depth, int maxReportingChain) {
        // Initialize the results list
        List<ReportingResult> results = new ArrayList<>();
        // Analyze recursively
        analyzeReportingRecursively(emp, depth, maxReportingChain, results);

        return results;
    }

    private void analyzeReportingRecursively(Employee emp, int depth, int maxReportingChain, List<ReportingResult> results) {
        //check if the 4 managers between employee and ceo is violated
        if(depth > maxReportingChain){
            results.add(new ReportingResult(emp.getFullName(), maxReportingChain, depth - maxReportingChain));
        }

        //recursively check for subordinates
        for(Employee sub : emp.getSubordinates()){
            analyzeReportingRecursively(sub, depth+1, maxReportingChain, results);
        }
    }
}
