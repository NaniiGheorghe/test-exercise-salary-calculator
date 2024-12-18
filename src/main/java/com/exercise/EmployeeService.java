package com.exercise;

public class EmployeeService {

    private final EmployeePostgresRepository databaseRepository;

    public EmployeeService(EmployeePostgresRepository databaseRepository) {
        this.databaseRepository = databaseRepository;
    }

    public int calculateSalary(Employee employee) {
        switch (employee.employeeType) {
            case INTERNSHIP: {
                return calculateInternshipSalary(employee);
            }
            case PART_TIME: {
                return calculatePartTimeSalary(employee);
            }
            case FULL_TIME: {
                return calculateFullTimeSalary(employee);
            }
            default: {
                throw new IllegalStateException("Unknown employee type");
            }
        }
    }

    // Internship employee is paid with a special rate
    private int calculateInternshipSalary(Employee employee) {
        double internshipRate = databaseRepository.getInternshipRate();
        return (int) (employee.hourRate * 8 * 22 * internshipRate);
    }

    // Part-time employee is paid for only 11 days from month
    private int calculatePartTimeSalary(Employee employee) {
        return employee.hourRate * 8 * 11;
    }

    // Part-time employee is paid for 22 days from month
    private int calculateFullTimeSalary(Employee employee) {
        return employee.hourRate * 8 * 22;
    }

}
