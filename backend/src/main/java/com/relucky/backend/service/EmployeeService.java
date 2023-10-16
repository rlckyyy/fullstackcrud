package com.relucky.backend.service;

import com.relucky.backend.dto.EmployeeDTO;
import com.relucky.backend.models.Employee;

import java.util.List;

public interface EmployeeService {
    void update(Integer id, EmployeeDTO employeeDTO);
    void save(EmployeeDTO employeeDTO);
    EmployeeDTO findById(Integer id);
    List<EmployeeDTO> findAll();
    void delete(Integer id);
}
