package by.tishalovichm.employee.mapper;

import by.tishalovichm.employee.dto.employee.ReqEmployeeDto;
import by.tishalovichm.employee.dto.employee.RespEmployeeDto;
import by.tishalovichm.employee.entity.Employee;
import org.mapstruct.Mapper;

@Mapper
public interface EmployeeMapper {

    Employee reqToEntity(ReqEmployeeDto dto);

    RespEmployeeDto entityToResp(Employee department);

}
