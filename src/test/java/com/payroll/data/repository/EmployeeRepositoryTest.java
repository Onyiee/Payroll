package com.payroll.data.repository;

import com.payroll.data.model.Employee;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Repository;
import org.springframework.test.context.jdbc.Sql;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Sql(scripts = {"classpath:db/insert.sql"})
@Repository
@Slf4j
class EmployeeRepositoryTest {

    @Autowired
    EmployeeRepository employeeRepository;

    @BeforeEach
    void setUp() {
    }

    @Test
    public void updateEmployeeRecord(){
        Employee employee = employeeRepository.findById(12).orElse(null);
        assert employee != null;
        assertThat(employee.getFirstName()).isEqualTo("Bob");
        assertThat(employee.getLastName()).isEqualTo("Dan");
        log.info("Employee before save-->{}",employee);

        employee.setFirstName("John");

        employeeRepository.save(employee);

        assertThat(employee.getFirstName()).isEqualTo("John");
        assertThat(employee.getLastName()).isEqualTo("Dan");

        assertThat(employee.getRole()).isEqualTo("HR");
        log.info("Employee after save --> {}", employee);
    }


}