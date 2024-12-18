import com.exercise.Employee;
import com.exercise.EmployeePostgresRepository;
import com.exercise.EmployeeService;
import com.exercise.EmployeeType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EmployeeServiceTest {

    private EmployeeService employeeService;

    @BeforeEach
    void setUp() {
        EmployeePostgresRepository employeePostgresRepository = new EmployeePostgresRepository();
        employeeService = new EmployeeService(employeePostgresRepository);
    }

    @Test
    void testCalculateInternshipSalary() {
        Employee employee = new Employee("Deandre Walker", 10, EmployeeType.INTERNSHIP);
        int salary = employeeService.calculateSalary(employee);
        assertEquals(1232, salary);
    }

    @Test
    void testCalculatePartTimeSalary() {
        Employee employee = new Employee("Deandre Walker", 20, EmployeeType.PART_TIME);
        int salary = employeeService.calculateSalary(employee);
        assertEquals(1760, salary);
    }

    @Test
    void testCalculateFullTimeSalary() {
        Employee employee = new Employee("Deandre Walker", 25, EmployeeType.FULL_TIME);
        int salary = employeeService.calculateSalary(employee);
        assertEquals(4400, salary);
    }

}
