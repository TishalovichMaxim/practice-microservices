package by.tishalovichm.employee.mapper;

import by.tishalovichm.employee.dto.department.ApiDepartmentDto;
import by.tishalovichm.employee.dto.department.RespDepartmentDto;
import by.tishalovichm.employee.entity.Department;
import org.mapstruct.Mapper;

@Mapper
public interface DepartmentMapper {

    Department apiToEntity(ApiDepartmentDto apiDepartmentDto);

    RespDepartmentDto apiToResp(ApiDepartmentDto apiDepartmentDto);

    RespDepartmentDto entityToResp(Department apiDepartmentDto);

}
