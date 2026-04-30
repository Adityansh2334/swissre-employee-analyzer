package com.swissre.app;

import com.swissre.app.model.Employee;
import com.swissre.app.model.ReportingResult;
import com.swissre.app.model.SalaryResult;
import com.swissre.app.service.EmployeeService;
import com.swissre.app.service.ReportingAnalyzer;
import com.swissre.app.service.SalaryAnalyzer;
import com.swissre.app.util.ConsolePrinter;
import com.swissre.app.util.CsvReader;

import java.io.InputStream;
import java.util.List;
import java.util.Map;

/*
* App class is the main class that is responsible for running the application
* Author: Aditya Kumar Behera
*/
public class App 
{
    public static void main( String[] args )
    {
        // Load the csv file from resources
        try (InputStream inputStream = App.class
                .getClassLoader()
                .getResourceAsStream("employees.csv")) {
            
            if (inputStream == null) {
                throw new RuntimeException("File not found in resources!");
            }
            // Read the csv file and create employees
            Map<Integer, Employee> employees = CsvReader.readCsvFile(inputStream);

            // Build the employee hierarchy
            EmployeeService empService = new EmployeeService();
            Employee ceo = empService.buildEmployeeHierarchy(employees);

            // Analyze salary
            SalaryAnalyzer salaryAnalyzer = new SalaryAnalyzer();
            List<SalaryResult> salaryResults = salaryAnalyzer.analyzeSalary(ceo);

            // Print salary results
            ConsolePrinter.printSalaryResults(salaryResults);

            // Analyze reporting
            ReportingAnalyzer reportingAnalyzer = new ReportingAnalyzer();
            List<ReportingResult> reportingResults = reportingAnalyzer.analyzeReporting(ceo, 1, 4);

            // Print reporting results
            ConsolePrinter.printReportingResults(reportingResults);

        } catch (Exception e) {
            // Print the error message in console
            System.err.println(e.getMessage());
        }
    }
}
