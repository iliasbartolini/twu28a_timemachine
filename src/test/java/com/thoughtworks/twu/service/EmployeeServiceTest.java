package com.thoughtworks.twu.service;

import com.thoughtworks.twu.domain.Employee;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class EmployeeServiceTest {

    @Test
    public void shouldSaveEmployee() {

        EmployeeService service = new EmployeeService();

        Employee employee = new Employee();

        employee.setName("Andy");

        service.saveEmployee(employee);

        List<Employee> employeeList = service.getAllEmployees();

        assertTrue(employeeList.contains(employee));

    }

    @Test
    public void shouldGetEmployeeByLogin() {
        EmployeeService service = new EmployeeService();

        Employee employee = new Employee();
        employee.setName("Andy");
        employee.setEmployee_decimal("1234");
        employee.setLogin("ashaw");

        service.saveEmployee(employee);

        Employee result = service.getEmployeeByLogin("ashaw");

        assertEquals("Andy", result.getName());

    }


}
