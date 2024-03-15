package com.shiva.restsimple.repository;

import com.shiva.restsimple.entity.Employee;
import lombok.Builder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
class EmployeeRepositoryTest {

    @Autowired
    private EmployeeRepository employeeRepository;

    private Employee employee;

    @BeforeEach
    public void setupTestData(){
        employee = Employee.builder()
                .id(Long.parseLong("1"))
                .name("NameOfEmplooyee")
                .age(21)
                .birthDate("01/01/2000")
                .build();
    }

    @Test
    @DisplayName("Check if employee saved in database.")
    void EmployeeRepository_SaveAll_ReturnSavedEmployee() {

        Employee result = employeeRepository.save(employee);

        Assertions.assertNotNull(result);
        Assertions.assertEquals(1,result.getId());
        Assertions.assertEquals("NameOfEmplooyee",result.getName());
    }

}