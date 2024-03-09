package com.shiva.restsimple.controller;

import com.shiva.restsimple.entity.Employee;
import com.shiva.restsimple.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1")
public class EmployeeController {

    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/test")
    public String test() {
        return "working";
    }

    @GetMapping("employees")
    public List<Employee> getEmployees(){
        return employeeService.getAllEmployees();
    }

    @GetMapping("employee/{id}")
    public Optional<Employee> getEmployee(@PathVariable Long id){
        return employeeService.getAllEmployee(id);
    }
    @PostMapping("employee")
    public Employee addEmployee(@RequestBody Employee employee){
        return employeeService.addEmployee(employee);
    }

    @DeleteMapping("employee/{id}")
    public void addEmployee(@PathVariable Long id){
         employeeService.deleteEmployee(id);
    }
}
