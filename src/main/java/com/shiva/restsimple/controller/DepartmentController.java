package com.shiva.restsimple.controller;

import com.shiva.restsimple.entity.Department;
import com.shiva.restsimple.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @CacheEvict(value="dept",allEntries = true)
    @CachePut(value="dept")
    @PostMapping("/departments")
    public Department saveDepartment( @RequestBody Department department)    {
        return departmentService.saveDepartment(department);
    }

    @Cacheable("dept")
    @GetMapping("/departments")
    public List<Department> fetchDepartmentList()   {
        return departmentService.fetchDepartmentList();
    }

    @GetMapping("/department/{id}")
    public Department getDepartment(@PathVariable("id") Long departmentId)   {
        return departmentService.getDepartment( departmentId);
    }

    @CacheEvict(value="dept",allEntries = true)
    @PutMapping("/departments/{id}")
    @CachePut(value="dept")
    public Department
    updateDepartment(@RequestBody Department department, @PathVariable("id") Long departmentId)   {
        return departmentService.updateDepartment(
                department, departmentId);
    }

    @DeleteMapping("/departments/{id}")
    @CacheEvict(value="dept")
    public String deleteDepartmentById(@PathVariable("id") Long departmentId)  {
        departmentService.deleteDepartmentById( departmentId);
        return "Deleted Successfully";
    }

}
