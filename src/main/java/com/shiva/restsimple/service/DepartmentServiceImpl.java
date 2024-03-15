package com.shiva.restsimple.service;

import java.sql.SQLOutput;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import com.shiva.restsimple.entity.Department;
import com.shiva.restsimple.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    private DepartmentRepository departmentRepository;

    public DepartmentServiceImpl(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }
    @Override
    public Department saveDepartment(Department department) {
        System.out.println(" Save called ..");
        return departmentRepository.save(department);
    }

    @Override
    public List<Department> fetchDepartmentList() {
        return (List<Department>)
                departmentRepository.findAll();
    }

    @Override
    public Department
    updateDepartment(Department department,  Long departmentId) {
        System.out.println(" UPdate is getting EEC################");
        Department depDB       = departmentRepository.findById(departmentId).get();

        if (Objects.nonNull(department.getDepartmentName())  && !"".equalsIgnoreCase(department.getDepartmentName())) {
            depDB.setDepartmentName(department.getDepartmentName());
        }

        if (Objects.nonNull( department.getDepartmentAddress())  && !"".equalsIgnoreCase(department.getDepartmentAddress())) {
            depDB.setDepartmentAddress(department.getDepartmentAddress());
        }

        if (Objects.nonNull(department.getDepartmentCode())
                && !"".equalsIgnoreCase(
                department.getDepartmentCode())) {
            depDB.setDepartmentCode(
                    department.getDepartmentCode());
        }

        return departmentRepository.save(depDB);
    }

    @Override
    public void deleteDepartmentById(Long departmentId) {
        departmentRepository.deleteById(departmentId);
    }

    @Override
    public Department getDepartment(Long departmentId) {
        Optional<Department> byId = departmentRepository.findById(departmentId);
        return byId.orElseThrow();
    }
}
