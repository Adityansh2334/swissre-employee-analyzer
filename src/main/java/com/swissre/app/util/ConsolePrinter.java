package com.swissre.app.util;

import com.swissre.app.model.ReportingResult;
import com.swissre.app.model.SalaryResult;

import java.util.List;

/*
* ConsolePrinter class is responsible for printing the salary and reporting analysis results in console
*/
public class ConsolePrinter {

    public static void printSalaryResults(List<SalaryResult> results) {

        System.out.println("========== Salary Analysis ==========");

        if (results == null || results.isEmpty()) {
            System.out.println("No salary violations found.");
            return;
        }

        for (SalaryResult r : results) {
            String message = buildSalaryMessage(r);
            System.out.println(message);
        }
    }

    private static String buildSalaryMessage(SalaryResult r) {

        return switch (r.getStatus()) {
            case BELOW_THRESHOLD -> String.format(
                    "Manager %s earns LESS than expected by %.2f",
                    r.getEmployeeName(),
                    r.getDifference()
            );
            case ABOVE_THRESHOLD -> String.format(
                    "Manager %s earns MORE than expected by %.2f",
                    r.getEmployeeName(),
                    r.getDifference()
            );
            default -> String.format(
                    "Manager %s salary is within expected range",
                    r.getEmployeeName()
            );
        };
    }

    public static void printReportingResults(List<ReportingResult> results) {

        System.out.println("\n========== Reporting Analysis ==========");

        if (results == null || results.isEmpty()) {
            System.out.println("No reporting violations found.");
            return;
        }

        for (ReportingResult r : results) {
            System.out.printf(
                    "Employee %s has reporting line too long by %d level(s)%n",
                    r.getEmployeeName(),
                    r.getLongReportingChain()
            );
        }
    }
}