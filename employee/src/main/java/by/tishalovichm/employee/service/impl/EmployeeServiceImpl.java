package by.tishalovichm.employee.service.impl;

import by.tishalovichm.employee.dal.EmployeeRepository;
import by.tishalovichm.employee.dto.department.ApiDepartmentDto;
import by.tishalovichm.employee.dto.employee.ReqEmployeeDto;
import by.tishalovichm.employee.dto.employee.RespEmployeeDto;
import by.tishalovichm.employee.entity.Employee;
import by.tishalovichm.employee.entity.EmployeeAndDepartment;
import by.tishalovichm.employee.exception.ResourceNotFoundException;
import by.tishalovichm.employee.mapper.DepartmentMapper;
import by.tishalovichm.employee.mapper.EmployeeMapper;
import by.tishalovichm.employee.service.DepartmentApiClient;
import by.tishalovichm.employee.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final DepartmentApiClient departmentApiClient;

    private final EmployeeMapper employeeMapper;

    private final DepartmentMapper departmentMapper;

    private final EmployeeRepository repository;

    @Override
    public RespEmployeeDto save(ReqEmployeeDto dto) {
        Employee employee = employeeMapper.reqToEntity(dto);

        return employeeMapper.entityToResp(repository.save(employee));
    }

    @Override
    @SneakyThrows
    public RespEmployeeDto get(Long id) {
        Employee employee = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(id));

        return employeeMapper.entityToResp(employee);
    }

    @Override
    @SneakyThrows
    public EmployeeAndDepartment getWithDepartment(Long id) {
        Employee employee = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(id));

        ApiDepartmentDto apiDepartment = departmentApiClient.get(
                employee.getDepartmentCode());

        return new EmployeeAndDepartment(
                employeeMapper.entityToResp(employee),
                departmentMapper.apiToResp(apiDepartment)
        );
    }
}
