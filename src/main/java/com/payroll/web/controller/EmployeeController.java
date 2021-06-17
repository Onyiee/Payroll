package com.payroll.web.controller;

import com.payroll.data.dto.EmployeeDto;
import com.payroll.data.model.Employee;
import com.payroll.service.employee.EmployeeService;
import com.payroll.web.exceptions.EmployeeException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/employee")
@Slf4j
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("")
    private List<Employee> findAll() {
        return employeeService.findAll();
    }

    @PostMapping("")
    public Employee save(@RequestBody EmployeeDto employeeDto) {
        return employeeService.save(employeeDto);
    }

    @GetMapping("/{id}")
    public Employee findById(@PathVariable("id") Integer id) {
        try {
            return employeeService.findById(id);
        } catch (EmployeeException e) {
            log.info(e.getMessage());
            return null;
        }

    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable("id") Integer id) {
        try {
            employeeService.deleteById(id);
        } catch (EmployeeException e) {
            log.info(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public Employee updateEmployee(@PathVariable Integer id,
                                   @Valid @RequestBody EmployeeDto employeeDto){
        return null;
    }
}
