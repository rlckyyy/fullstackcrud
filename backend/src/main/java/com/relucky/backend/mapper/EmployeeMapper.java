package com.relucky.backend.mapper;

import com.relucky.backend.dto.EmployeeDTO;
import com.relucky.backend.models.Employee;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface EmployeeMapper {
    EmployeeMapper INSTANCE = Mappers.getMapper(EmployeeMapper.class);

    Employee toModel(EmployeeDTO employeeDTO);
    EmployeeDTO toDto(Employee employee);


}
