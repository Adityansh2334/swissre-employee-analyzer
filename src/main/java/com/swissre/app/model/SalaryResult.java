package com.swissre.app.model;

/*
* SalaryResult class is responsible for storing the salary analysis results and print into console
*/
public class SalaryResult {
    private String employeeName;
    private double salary;
    private EnumSalaryStatus status;
    private double difference;

    public SalaryResult(String employeeName, double salary, EnumSalaryStatus status, double difference) {
        this.employeeName = employeeName;
        this.salary = salary;
        this.status = status;
        this.difference = difference;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public EnumSalaryStatus getStatus() {
        return status;
    }

    public void setStatus(EnumSalaryStatus status) {
        this.status = status;
    }

    public double getDifference() {
        return difference;
    }

    public void setDifference(double difference) {
        this.difference = difference;
    }
}
