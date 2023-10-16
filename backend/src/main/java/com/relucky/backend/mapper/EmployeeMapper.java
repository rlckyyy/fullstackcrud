package com.relucky.backend.mapper;

import com.relucky.backend.dto.EmployeeDTO;
import com.relucky.backend.models.Employee;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper
public interface EmployeeMapper {
    @Mapping(target = "id", ignore = true)
    Employee toModel(EmployeeDTO employeeDTO);

    EmployeeDTO toDto(Employee employee);


}
