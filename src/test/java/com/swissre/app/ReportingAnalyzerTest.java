package com.swissre.app;

import com.swissre.app.config.AppConfig;
import com.swissre.app.model.Employee;
import com.swissre.app.model.ReportingResult;
import com.swissre.app.service.ReportingAnalyzer;
import com.swissre.app.util.ConfigLoader;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReportingAnalyzerTest {

    @Test
    void testDepthViolation() {
        Employee e1 = new Employee(1, "A", "B", 1000, null);
        Employee e2 = new Employee(2, "C", "D", 1000, 1);
        Employee e3 = new Employee(3, "E", "F", 1000, 2);
        Employee e4 = new Employee(4, "G", "H", 1000, 3);
        Employee e5 = new Employee(5, "I", "J", 1000, 4);
        Employee e6 = new Employee(6, "K", "L", 1000, 5); // violation

        e1.addSubordinate(e2);
        e2.addSubordinate(e3);
        e3.addSubordinate(e4);
        e4.addSubordinate(e5);
        e5.addSubordinate(e6);

        // Load the config file
        AppConfig appConfig = ConfigLoader.loadConfig("config.csv");

        ReportingAnalyzer reportingAnalyzer = new ReportingAnalyzer();
        List<ReportingResult> results = reportingAnalyzer.analyzeReporting(e1, 0, appConfig.maxReportingDepth());

        assertEquals(1,results.size());
    }
}
