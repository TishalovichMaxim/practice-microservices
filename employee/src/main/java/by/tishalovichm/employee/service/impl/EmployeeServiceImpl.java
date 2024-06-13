package by.tishalovichm.employee.service.impl;

import by.tishalovichm.employee.dal.EmployeeRepository;
import by.tishalovichm.employee.dto.ReqEmployeeDto;
import by.tishalovichm.employee.dto.RespEmployeeDto;
import by.tishalovichm.employee.entity.Employee;
import by.tishalovichm.employee.exception.ResourceNotFoundException;
import by.tishalovichm.employee.mapper.EmployeeMapper;
import by.tishalovichm.employee.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeMapper mapper;

    private final EmployeeRepository repository;

    @Override
    public RespEmployeeDto save(ReqEmployeeDto dto) {
        Employee employee = mapper.reqToEntity(dto);

        return mapper.entityToResp(repository.save(employee));
    }

    @Override
    @SneakyThrows
    public RespEmployeeDto get(Long id) {
        Employee employee = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(id));

        return mapper.entityToResp(employee);
    }

}
