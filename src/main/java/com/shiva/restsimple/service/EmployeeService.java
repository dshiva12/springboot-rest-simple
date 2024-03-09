package com.shiva.restsimple.service;

import com.shiva.restsimple.entity.Employee;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {
    List<Employee> getAllEmployees();

    Optional<Employee> getAllEmployee(Long id);

    Employee addEmployee(Employee employee);

    void deleteEmployee(Long id);
}
