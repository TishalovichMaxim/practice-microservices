package by.tishalovichm.employee.entity;

import by.tishalovichm.employee.dto.department.RespDepartmentDto;
import by.tishalovichm.employee.dto.employee.RespEmployeeDto;
import by.tishalovichm.employee.dto.organization.RespOrganizationDto;

public record EmployeeInfo(
        RespEmployeeDto employee,
        RespDepartmentDto department,
        RespOrganizationDto organization
) {
}
