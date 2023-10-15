package com.relucky.backend.controllers;

import com.relucky.backend.models.Employee;
import com.relucky.backend.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/employee")
@CrossOrigin(origins = "http://localhost:4200")
public class EmployeeController {
    private final EmployeeService service;

    @GetMapping
    ResponseEntity<?> getAll() {
        return ResponseEntity
                .ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employee> getOne(@PathVariable Integer id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @PostMapping()
    ResponseEntity<String> create(
            @RequestBody Employee employee
    ) {
        service.save(employee);
        return ResponseEntity.ok("Employee saved");
    }

    @PutMapping("/{id}")
    ResponseEntity<String> update(
            @PathVariable Integer id,
            @RequestBody Employee employee
    ) {
        service.update(id, employee);
        return ResponseEntity.ok("User data changed");
    }

    @DeleteMapping("/{id}")
    ResponseEntity<String> delete(@PathVariable Integer id) {
        service.delete(id);
        return ResponseEntity.ok("User deleted");
    }

}
