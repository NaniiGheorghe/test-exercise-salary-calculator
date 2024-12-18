package com.exercise;

public class Employee {
    public String name;
    public int hourRate;
    public EmployeeType employeeType;

    public Employee(String name, int hourRate, EmployeeType employeeType) {
        this.name = name;
        this.hourRate = hourRate;
        this.employeeType = employeeType;
    }
}
