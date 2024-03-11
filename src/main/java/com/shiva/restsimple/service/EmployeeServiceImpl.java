package com.shiva.restsimple.service;

import com.shiva.restsimple.entity.Employee;
import com.shiva.restsimple.exception.EmployeeException;
import com.shiva.restsimple.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    private EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Optional <Employee> getAllEmployee(Long id) throws EmployeeException {
        Optional <Employee> employee= employeeRepository.findById(id);
        if(employee.isPresent()) {
            return employee;
        } else {
            throw new EmployeeException("Employee not found for Id ");
        }

    }

    @Override
    public Employee addEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }
}
