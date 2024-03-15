package com.shiva.restsimple.controller;

import com.shiva.restsimple.entity.Employee;
import com.shiva.restsimple.repository.EmployeeRepository;
import com.shiva.restsimple.service.EmployeeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.jsonPath;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//Approach 2: Mockito unit test for EmployeeController class.
@SpringBootTest
class EmployeeControllerTest {

    Employee employee;
    @InjectMocks
    private EmployeeController employeeController;
    @Mock
    private EmployeeService employeeService;

    @BeforeEach
    void setUp() {
        employee = Employee.builder()
                .id(Long.parseLong("1"))
                .name("NameOfEmplooyee")
                .salary(20000)
                .age(21)
                .birthDate("01/01/2000")
                .build();
    }

    @Test
    void getEmployees() {
    }

    @Test
    void getEmployee() throws Exception {
        int id = 1;
        when(employeeService.getEmployee((long) id)).thenReturn(Optional.of(employee));

        ResponseEntity result =  employeeController.getEmployee((long) id);

        String statusCode= String.valueOf(result.getStatusCode());
        Optional<Employee> resultEmployee= (Optional<Employee>) result.getBody();
        assertEquals("200 OK",statusCode);
        String empName =resultEmployee.isPresent() ? resultEmployee.get().getName() : "NotFound";
        int age =resultEmployee.isPresent() ? resultEmployee.get().getAge() : 0;
        int salary =resultEmployee.isPresent() ? resultEmployee.get().getSalary() : 0;
        String birthDay =resultEmployee.isPresent() ? resultEmployee.get().getBirthDate() : "NotFound";
        assertEquals("NameOfEmplooyee",empName);
        assertEquals(21,age);
        assertEquals(20000,salary);
        assertEquals("01/01/2000",birthDay);
    }

    @Test
    void addEmployee() {
    }

    @Test
    void testAddEmployee() {
    }
}