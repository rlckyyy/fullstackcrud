package com.relucky.backend.controllers;

import com.relucky.backend.dto.EmployeeDTO;
import com.relucky.backend.mapper.EmployeeMapper;
import com.relucky.backend.models.Employee;
import com.relucky.backend.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/employee")
public class EmployeeController {
    private final EmployeeService service;

    @GetMapping
    ResponseEntity<?> getAll() {
        return ResponseEntity
                .ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmployeeDTO> getOne(@PathVariable Integer id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @PostMapping()
    ResponseEntity<String> create(
            @RequestBody EmployeeDTO employeeDTO
    ) {
        service.save(employeeDTO);
        return ResponseEntity.ok("Employee saved");
    }

    @PutMapping("/{id}")
    ResponseEntity<String> update(
            @PathVariable Integer id,
            @RequestBody EmployeeDTO employeeDTO
    ) {
        service.update(id, employeeDTO);
        return ResponseEntity.ok("User data changed");
    }

    @DeleteMapping("/{id}")
    ResponseEntity<String> delete(@PathVariable Integer id) {
        service.delete(id);
        return ResponseEntity.ok("User deleted");
    }

}
