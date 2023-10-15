package com.relucky.backend.service;

import com.relucky.backend.models.Employee;

import java.util.List;

public interface EmployeeService {
    void update(Integer id, Employee employee);
    void save(Employee employee);
    Employee findById(Integer id);
    List<Employee> findAll();
    void delete(Integer id);
}
