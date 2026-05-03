package com.swissre.app;

import com.swissre.app.config.AppConfig;
import com.swissre.app.util.ConfigLoader;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ConfigLoaderTest {

    @Test
    void shouldUseDefaultValuesIfKeyMissing() {

        AppConfig config = ConfigLoader.loadConfig("config-missing.csv");

        assertEquals(20, config.minSalaryPercentage());
        assertEquals(50, config.maxSalaryPercentage());
        assertEquals(4, config.maxReportingDepth());
    }

    @Test
    void shouldThrowExceptionWhenFileNotFound() {

        Exception exception = assertThrows(RuntimeException.class, () -> ConfigLoader.loadConfig("invalid-file.csv"));

        assertTrue(exception.getMessage().contains("Config file not found"));
    }
}
