package com.swissre.app.model;

import java.util.ArrayList;
import java.util.List;

/*
* Employee class is responsible for representing an employee and their details.
* It is a POJO (Plain Old Java Object) that contains the employee's details.
*/
public class Employee {
    private final int id;
    private final String firstName;
    private final String lastName;
    private final Integer managerId;
    private final double salary;
    private final List<Employee> subordinates = new ArrayList<>();

    public Employee(int id, String firstName, String lastName, double salary, Integer managerId) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
        this.managerId = managerId;
    }

    /*
    * Adds a subordinate to the employee's list of subordinates.
    */
    public void addSubordinate(Employee emp) {
        subordinates.add(emp);
    }

    /*
    * Returns the list of subordinates for the employee.
    */
    public List<Employee> getSubordinates() {
        return subordinates;
    }

    /*
    * Returns the salary of the employee.
    */
    public double getSalary() {
        return salary;
    }

    /*
    * Returns the id of the employee.
    */
    public int getId() {
        return id;
    }

    /*
    * Returns the manager id of the employee.
    */
    public Integer getManagerId() {
        return managerId;
    }

    /*
    * Returns the full name of the employee.
    */
    public String getFullName() {
        return firstName + " " + lastName;
    }

}
