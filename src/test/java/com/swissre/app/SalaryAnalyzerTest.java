package com.swissre.app;

import com.swissre.app.config.SalaryConfig;
import com.swissre.app.model.Employee;
import com.swissre.app.model.SalaryResult;
import com.swissre.app.service.SalaryAnalyzer;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SalaryAnalyzerTest {

    @Test
    void testSalaryBelowRange() {
        Employee manager = new Employee(1, "A", "B", 1000, null);
        Employee e1 = new Employee(2, "C", "D", 1000, 1);
        Employee e2 = new Employee(3, "E", "F", 1000, 1);

        manager.addSubordinate(e1);
        manager.addSubordinate(e2);

        SalaryConfig salaryConfig = new SalaryConfig(20,50);
        SalaryAnalyzer salaryAnalyzer = new SalaryAnalyzer(salaryConfig);
        List<SalaryResult> result = salaryAnalyzer.analyzeSalary(manager);

        assertEquals(1, result.size());
        assertEquals("BELOW_THRESHOLD", result.get(0).getStatus().name());
    }

    @Test
    void testSalaryAboveRange() {
        Employee manager = new Employee(1, "A", "B", 5000, null);
        Employee e1 = new Employee(2, "C", "D", 1000, 1);
        Employee e2 = new Employee(3, "E", "F", 1000, 1);

        manager.addSubordinate(e1);
        manager.addSubordinate(e2);

        SalaryConfig salaryConfig = new SalaryConfig(20,50);
        SalaryAnalyzer salaryAnalyzer = new SalaryAnalyzer(salaryConfig);
        List<SalaryResult> result = salaryAnalyzer.analyzeSalary(manager);

        assertEquals(1, result.size());
        assertEquals("ABOVE_THRESHOLD", result.get(0).getStatus().name());
    }

    @Test
    void testSalaryAtMinBoundary() {
        Employee manager = new Employee(1, "A", "B", 1200, null);
        Employee e1 = new Employee(2, "C", "D", 1000, 1);

        manager.addSubordinate(e1);

        SalaryConfig salaryConfig = new SalaryConfig(20,50);
        SalaryAnalyzer salaryAnalyzer = new SalaryAnalyzer(salaryConfig);
        List<SalaryResult> result = salaryAnalyzer.analyzeSalary(manager);

        assertTrue(result.isEmpty());
    }

    @Test
    void testSalaryAtMaxBoundary() {
        Employee manager = new Employee(1, "A", "B", 1500, null);
        Employee e1 = new Employee(2, "C", "D", 1000, 1);

        manager.addSubordinate(e1);

        SalaryConfig salaryConfig = new SalaryConfig(20,50);
        SalaryAnalyzer salaryAnalyzer = new SalaryAnalyzer(salaryConfig);
        List<SalaryResult> result = salaryAnalyzer.analyzeSalary(manager);

        assertTrue(result.isEmpty());
    }

    @Test
    void testManagerWithNoSubordinates() {
        Employee manager = new Employee(1, "A", "B", 1000, null);

        SalaryConfig salaryConfig = new SalaryConfig(20,50);
        SalaryAnalyzer salaryAnalyzer = new SalaryAnalyzer(salaryConfig);
        List<SalaryResult> result = salaryAnalyzer.analyzeSalary(manager);

        assertTrue(result.isEmpty());
    }
}
