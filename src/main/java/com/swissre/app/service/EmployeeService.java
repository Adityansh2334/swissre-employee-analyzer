package com.swissre.app.service;

import com.swissre.app.model.Employee;

import java.util.Map;

/*
* EmployeeService class is responsible for building the hierarchical structure of employees
*/
public class EmployeeService {

    //build hierarchical structure of employees
    public Employee buildEmployeeHierarchy(Map<Integer, Employee> employees) {

        // Find the CEO
        Employee ceo = null;

        for (Employee emp : employees.values()) {
            // If the employee has no manager, they are the CEO
            if(emp.getManagerId() == null){
                ceo = emp;
            } else{
                // Find the manager and add the employee as a subordinate(direct reports)
                Integer managerId = emp.getManagerId();

                if (managerId != null) {
                    Employee manager = employees.get(managerId);

                    if (!employees.containsKey(managerId)) {
                        throw new IllegalArgumentException("Invalid manager reference: " + managerId);
                    }

                    manager.addSubordinate(emp);
                }
            }
        }
        return ceo;
    }
}
