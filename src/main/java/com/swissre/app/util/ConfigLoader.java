package com.swissre.app.util;

import com.swissre.app.config.AppConfig;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class ConfigLoader {

    public static AppConfig loadConfig(String fileName) {

        try {
            InputStream is = ConfigLoader.class
                    .getClassLoader()
                    .getResourceAsStream(fileName);

            if (is == null) {
                throw new RuntimeException("Config file not found: " + fileName);
            }

            BufferedReader reader = new BufferedReader(new InputStreamReader(is));

            Map<String, Integer> configMap = new HashMap<>();

            String line;
            reader.readLine(); // skip header

            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");

                String key = parts[0].trim();
                int value = Integer.parseInt(parts[1].trim());

                configMap.put(key, value);
            }

            return new AppConfig(
                    configMap.getOrDefault("minSalaryPercentage", 20),
                    configMap.getOrDefault("maxSalaryPercentage", 50),
                    configMap.getOrDefault("maxReportingDepth", 4)
            );

        } catch (Exception e) {
            throw new RuntimeException("Error reading config file", e);
        }
    }
}