package by.tishalovichm.employee.entity;

import by.tishalovichm.employee.dto.department.RespDepartmentDto;
import by.tishalovichm.employee.dto.employee.RespEmployeeDto;

public record EmployeeAndDepartment(
        RespEmployeeDto employee,
        RespDepartmentDto department
) {
}
