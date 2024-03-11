package com.shiva.restsimple.service;

import com.shiva.restsimple.entity.Employee;
import com.shiva.restsimple.exception.EmployeeException;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {
    List<Employee> getAllEmployees();

    Optional<Employee> getAllEmployee(Long id) throws EmployeeException;

    Employee addEmployee(Employee employee);

    void deleteEmployee(Long id);
}
