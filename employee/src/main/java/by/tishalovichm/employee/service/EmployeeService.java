package by.tishalovichm.employee.service;

import by.tishalovichm.employee.dto.ReqEmployeeDto;
import by.tishalovichm.employee.dto.RespEmployeeDto;

public interface EmployeeService {

    RespEmployeeDto save(ReqEmployeeDto dto);

    RespEmployeeDto get(Long id);

}
