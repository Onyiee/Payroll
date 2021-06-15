

package com.payroll.service.employee;

import com.payroll.data.model.Employee;
import com.payroll.data.repository.EmployeeRepository;
import com.payroll.web.exceptions.EmployeeException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService{
    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    public Employee save(Employee employee) {
        Employee newEmployee = employeeRepository.save(employee);
        return newEmployee;
    }

    @Override
    public Employee findById(Integer id) throws EmployeeException {
       Employee employee = employeeRepository.findById(id).orElseThrow(
               ()-> new EmployeeException("Employee not found")
       );
       return employee;
    }

    @Override
    public List<Employee> findAll() {
        List<Employee> employees = employeeRepository.findAll();
        return employees;
    }

    @Override
    public void deleteById(Integer id) throws EmployeeException {
        Employee employee = employeeRepository.findById(id).orElseThrow(
                ()-> new EmployeeException("Employee with that ID doesn't exist.")
        );
        employeeRepository.delete(employee);
    }

}
