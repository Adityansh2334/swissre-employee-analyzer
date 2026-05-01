package com.swissre.app.service;

import com.swissre.app.config.SalaryConfig;
import com.swissre.app.model.Employee;
import com.swissre.app.model.SalaryResult;
import com.swissre.app.model.EnumSalaryStatus;

import java.util.ArrayList;
import java.util.List;

/*
* SalaryAnalyzer class is responsible for analyzing the salary of employees
*/
public class SalaryAnalyzer {

    private final SalaryConfig salaryConfig;

    public SalaryAnalyzer(SalaryConfig config) {
        this.salaryConfig = config;
    }

    public List<SalaryResult> analyzeSalary(Employee manager) {
        // Initialize the results list
        List<SalaryResult> results = new ArrayList<>();

        // Analyze recursively
        analyzeRecursively(manager, results);

        return results;
    }

    private void analyzeRecursively(Employee manager, List<SalaryResult> results) {
        List<Employee> subordinates = manager.getSubordinates();

        // Base case: if no subordinates, return
        // If no subordinates, return nothing to validate
        if(subordinates.isEmpty()){
            return;
        }

        // Step 1: Calculate the average salary of the manager's subordinates
        double totalSalary = 0;
        for(Employee sub : subordinates){
            totalSalary += sub.getSalary();
        }
        double averageSalary = totalSalary / subordinates.size();

        // Step 2: Define capped allowed salary
        double minAllowedSalary = averageSalary * salaryConfig.minMultiplier(); // 20% minimum salary
        double maxAllowedSalary = averageSalary * salaryConfig.maxMultiplier(); // 50% maximum salary

        // Step 3: Validate Manager's salary
        double managerSalary = manager.getSalary();

        if(managerSalary < minAllowedSalary){
            //calculate the salary difference
            double salaryDifference = managerSalary - minAllowedSalary;
            results.add(new SalaryResult(manager.getFullName(), managerSalary, EnumSalaryStatus.BELOW_THRESHOLD, salaryDifference));
        } else if(managerSalary > maxAllowedSalary){
            //calculate the salary difference
            double salaryDifference = managerSalary - maxAllowedSalary;
            results.add(new SalaryResult(manager.getFullName(),managerSalary, EnumSalaryStatus.ABOVE_THRESHOLD, salaryDifference));
        }

        // Step 4: Recursively validate subordinates
        for(Employee sub : subordinates){
            analyzeRecursively(sub, results);
        }
    }
}
