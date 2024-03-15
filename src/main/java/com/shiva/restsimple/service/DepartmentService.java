package com.shiva.restsimple.service;

import com.shiva.restsimple.entity.Department;

import java.util.List;

public interface DepartmentService {
    Department saveDepartment(Department department);

    List<Department> fetchDepartmentList();

    Department updateDepartment(Department department, Long departmentId);

    void deleteDepartmentById(Long departmentId);

    Department getDepartment(Long departmentId);
}
