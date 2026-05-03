package com.swissre.app.util;

import com.swissre.app.config.AppConfig;

import java.io.BufferedReader;
import java.io.IOException;
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

            Map<String, Integer> configMap = getStringIntegerMap(fileName, is);

            return new AppConfig(
                    configMap.getOrDefault("minSalaryPercentage", 20),
                    configMap.getOrDefault("maxSalaryPercentage", 50),
                    configMap.getOrDefault("maxReportingDepth", 4)
            );

        } catch (RuntimeException e) {
            // preserve exceptions
            throw e;
        } catch (Exception e) {
            // unexpected errors
            throw new RuntimeException("Error reading config file", e);
        }
    }

    private static Map<String, Integer> getStringIntegerMap(String fileName, InputStream is) throws IOException {

        if (is == null) {
            throw new RuntimeException("Config file not found: " + fileName);
        }

        BufferedReader reader = new BufferedReader(new InputStreamReader(is));

        Map<String, Integer> configMap = new HashMap<>();

        String line;
        reader.readLine(); // skip header

        while ((line = reader.readLine()) != null) {

            String[] parts = line.split(",");

            if (parts.length < 2) {
                continue; // skip invalid rows
            }

            String key = parts[0].trim();
            int value = Integer.parseInt(parts[1].trim());

            configMap.put(key, value);
        }

        return configMap;
    }
}