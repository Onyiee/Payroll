package com.payroll.service.employee;

import com.payroll.data.dto.EmployeeDto;
import com.payroll.data.model.Employee;
import com.payroll.web.exceptions.EmployeeException;

import java.util.List;

public interface EmployeeService {
    Employee save(EmployeeDto employeeDto);
    Employee findById(Integer id) throws EmployeeException;
    List<Employee> findAll();
    void deleteById(Integer id) throws EmployeeException;
    Employee update(EmployeeDto employeeDto);
}
