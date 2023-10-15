package com.relucky.backend.service.impl;

import com.relucky.backend.models.Employee;
import com.relucky.backend.repository.EmployeeRepository;
import com.relucky.backend.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository repository;

    @Override
    public void update(Integer id, Employee model) {
        Employee employee = Employee.builder()
                .id(id)
                .name(model.getName())
                .surname(model.getSurname())
                .age(model.getAge())
                .email(model.getEmail())
                .salary(model.getSalary())
                .build();
        repository.save(employee);
    }

    @Override
    public void save(Employee employee) {
        var em = repository.findByEmail(employee.getEmail());

        if (em.isPresent()) {
            throw new IllegalArgumentException("email registered yet");
        }

        repository.save(employee);
    }

    @Override
    public Employee findById(Integer id) {
        return repository.findById(id).orElseThrow();
    }

    @Override
    public List<Employee> findAll() {
        return repository.findAll(Sort.by(Sort.Direction.ASC,"id"));
    }

    @Override
    public void delete(Integer id) {
        repository.deleteById(id);
    }
}
