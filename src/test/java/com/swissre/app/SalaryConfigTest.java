package com.swissre.app;

import com.swissre.app.config.SalaryConfig;
import com.swissre.app.model.Employee;
import com.swissre.app.model.SalaryResult;
import com.swissre.app.service.SalaryAnalyzer;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class SalaryConfigTest {
    @Test
    void shouldCalculateCorrectMultipliers() {
        SalaryConfig config = new SalaryConfig(20, 50);

        assertEquals(1.2, config.getMinMultiplier());
        assertEquals(1.5, config.getMaxMultiplier());
    }

    @Test
    void shouldThrowExceptionForInvalidRange() {
        assertThrows(IllegalArgumentException.class,
                () -> new SalaryConfig(50, 20));
    }

    @Test
    void shouldUseConfiguredPercentagesCorrectly() {
        SalaryConfig config = new SalaryConfig(20, 50);
        SalaryAnalyzer analyzer = new SalaryAnalyzer(config);

        Employee manager = new Employee(1, "A", "B", 60000, null);
        Employee e1 = new Employee(2, "C", "D", 50000, 1);

        manager.addSubordinate(e1);

        List<SalaryResult> results = analyzer.analyzeSalary(manager);

        // avg = 50000 → min = 60000 → manager = 60000 → valid
        assertTrue(results.isEmpty());
    }
}
