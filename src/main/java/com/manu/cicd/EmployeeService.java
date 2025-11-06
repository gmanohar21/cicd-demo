package com.manu.cicd;


import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    private final EmployeeRepository repo;

    public EmployeeService(EmployeeRepository repo) {
        this.repo = repo;
    }

    public List<Employee> getAllEmployees() {
        return repo.findAll();
    }

    public Employee getEmployeeById(Long id) {
        return repo.findById(id).orElseThrow();
    }

    public Employee addEmployee(Employee employee) {
        return repo.save(employee);
    }

    public Employee updateEmployee(Long id, Employee employee) {
        Employee existing = getEmployeeById(id);
        existing.setName(employee.getName());
        existing.setRole(employee.getRole());
        existing.setSalary(employee.getSalary());
        return repo.save(existing);
    }

    public void deleteEmployee(Long id) {
        repo.deleteById(id);
    }
}

