package by.tishalovichm.employee.service;

import by.tishalovichm.employee.dto.employee.ReqEmployeeDto;
import by.tishalovichm.employee.dto.employee.RespEmployeeDto;
import by.tishalovichm.employee.entity.EmployeeInfo;

public interface EmployeeService {

    RespEmployeeDto save(ReqEmployeeDto dto);

    RespEmployeeDto get(Long id);

    EmployeeInfo getInfo(Long id);

}
