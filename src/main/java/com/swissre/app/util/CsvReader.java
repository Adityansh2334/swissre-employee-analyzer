package com.swissre.app.util;

import com.swissre.app.model.Employee;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/*
* CsvReader class is responsible for reading the csv file and creating a map of employees
*/
public class CsvReader {

    public static Map<Integer, Employee> readCsvFile(InputStream fileInputStream) throws Exception{
        Map<Integer, Employee> employees = new HashMap<>(); // create a hashmap to store employees

        // Read the csv file and create employees from the file
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(fileInputStream))){
            String line = reader.readLine(); // skip the first line as header

            // Iterate over the file and create employees
            while((line = reader.readLine() )!= null){
                String[] values = line.split(",");

                // Validate the values
                if(values.length < 4){
                    throw new IllegalArgumentException("Invalid CSV format");
                }

                // Parse the values
                int id = Integer.parseInt(values[0]);
                String firstName = values[1];
                String lastName = values[2];
                double salary = Double.parseDouble(values[3]);
                Integer managerId = values.length > 4 ? Integer.parseInt(values[4]) : null;

                // Create employee object and add to the map
                Employee employee = new Employee(id, firstName, lastName, salary, managerId);
                employees.put(id, employee);

            }
        }
        return employees;
    }
}
