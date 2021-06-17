package com.payroll.service.employee;

import com.payroll.data.dto.EmployeeDto;
import com.payroll.data.model.Employee;
import com.payroll.data.repository.EmployeeRepository;
import com.payroll.web.exceptions.EmployeeException;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Service
@Slf4j
public class EmployeeServiceImpl implements EmployeeService{
    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public Employee save(EmployeeDto employeeDto) {
        Employee employee = new Employee();
        modelMapper.map(employeeDto,employee);
        log.info("Employee after mapping -->{}",employee);
        return employeeRepository.save(employee);
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

    @Override
    public Employee update(EmployeeDto employeeDto) {
        return null;
    }

}
