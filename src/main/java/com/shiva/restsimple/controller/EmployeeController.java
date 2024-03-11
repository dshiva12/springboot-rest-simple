package com.shiva.restsimple.controller;

import com.shiva.restsimple.entity.Employee;
import com.shiva.restsimple.service.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1")
public class EmployeeController {

    private EmployeeService employeeService;

    Logger logger = LoggerFactory.getLogger(EmployeeController.class);

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/test")
    public String test() {
        return "working";
    }

    @GetMapping("employees")
    public List<Employee> getEmployees(){
        logger.trace("A TRACE Message");
        logger.debug("A DEBUG Message");
        logger.info("An INFO Message");
        logger.warn("A WARN Message");
        logger.error("An ERROR Message");
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
