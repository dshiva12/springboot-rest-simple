package com.shiva.restsimple.service;

import com.shiva.restsimple.entity.Employee;
import com.shiva.restsimple.repository.EmployeeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
class EmployeeServiceImplTest {

    @Mock
    EmployeeRepository employeeRepository;

    @InjectMocks
    EmployeeServiceImpl employeeService;

    Employee employee;

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
    void testGetEmployee() {
        int id = 1;
        when(employeeRepository.findById((long) id)).thenReturn(Optional.of(employee));
        Optional<Employee> resultEmployee =  employeeService.getEmployee((long) id);
        String empName =resultEmployee.isPresent() ? resultEmployee.get().getName() : "NotFound";
        int age =resultEmployee.isPresent() ? resultEmployee.get().getAge() : 0;
        int salary =resultEmployee.isPresent() ? resultEmployee.get().getSalary() : 0;
        String birthDay =resultEmployee.isPresent() ? resultEmployee.get().getBirthDate() : "NotFound";
        assertEquals("NameOfEmplooyee",empName);
        assertEquals(21,age);
        assertEquals(20000,salary);
        assertEquals("01/01/2000",birthDay);
    }
}