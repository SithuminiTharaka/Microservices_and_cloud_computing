package com.example.department.controller;

import com.example.department.entity.Department;
import com.example.department.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/department")
public class DepartmentController {
    @Autowired
    private DepartmentRepository departmentRepository;

    @PostMapping
    public Department save(@RequestBody Department department) {
        return departmentRepository.save(department);
    }

    @GetMapping("/{id}")
    public Optional<Department> findById(@PathVariable Long id) {
        return departmentRepository.findById(id);
    }

    @GetMapping
    public List<Department> getAllDepartments() {
        return departmentRepository.findAll();
    }
}
