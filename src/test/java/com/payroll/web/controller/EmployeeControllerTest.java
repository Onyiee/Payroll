package com.payroll.web.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.payroll.data.model.Employee;
import com.payroll.service.employee.EmployeeService;
import lombok.Data;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;


import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@Data
@SpringBootTest
@AutoConfigureMockMvc
@Sql(scripts="classpath:db/insert.sql")
class EmployeeControllerTest {

    @Autowired
    private MockMvc mockMvc;


    @BeforeEach
    void setUp() {

    }



    @Test
    void getAllEmployeesTest()throws  Exception{
        mockMvc.perform(get("/employee"))
                .andDo(print()).
                andExpect(status().isOk());
    }

    @Test
    void saveNewEmployeeTest() throws Exception {
        Employee employee = new Employee();
        employee.setFirstName("Janet");
        employee.setLastName("Hams");
        employee.setRole("CTO");

        ObjectMapper mapper = new ObjectMapper();

        mockMvc.perform(post("/employee")
                .contentType("application/json").content(mapper.writeValueAsString(employee)))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void findEmployeeByIdTest() throws Exception {
        mockMvc.perform(get("/employee/12"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void deleteEmployeeByIdTest() throws Exception{
        mockMvc.perform(delete("/employee/12"))
                .andDo(print())
                .andExpect(status().isOk());
    }
}