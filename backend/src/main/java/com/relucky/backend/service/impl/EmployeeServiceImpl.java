package com.relucky.backend.service.impl;

import com.relucky.backend.dto.EmployeeDTO;
import com.relucky.backend.mapper.EmployeeMapper;
import com.relucky.backend.models.Employee;
import com.relucky.backend.repository.EmployeeRepository;
import com.relucky.backend.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository repository;
    private final EmployeeMapper employeeMapper;

    @Override
    public void update(Integer id, EmployeeDTO model) {
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
    public void save(EmployeeDTO employeeDTO) {
        var em = repository.findByEmail(employeeDTO.getEmail());
        if (em.isPresent()) {
            throw new IllegalArgumentException("email registered yet");
        }
        repository.save(employeeMapper.toModel(employeeDTO));
    }

    @Override
    public EmployeeDTO findById(Integer id) {
        return employeeMapper.toDto(repository.findById(id).orElseThrow());
    }

    @Override
    public List<EmployeeDTO> findAll() {
        return repository.findAll().stream().map(employeeMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id) {
        repository.deleteById(id);
    }
}
