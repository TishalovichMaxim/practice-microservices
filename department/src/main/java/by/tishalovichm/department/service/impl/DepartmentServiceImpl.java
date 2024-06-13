package by.tishalovichm.department.service.impl;

import by.tishalovichm.department.dal.DepartmentRepository;
import by.tishalovichm.department.dto.ReqDepartmentDto;
import by.tishalovichm.department.dto.RespDepartmentDto;
import by.tishalovichm.department.entity.Department;
import by.tishalovichm.department.exception.ResourceNotFoundException;
import by.tishalovichm.department.mapper.DepartmentMapper;
import by.tishalovichm.department.service.DepartmentService;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;

@RequiredArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {

    private final DepartmentMapper mapper;

    private final DepartmentRepository repository;

    @Override
    public RespDepartmentDto save(ReqDepartmentDto dto) {
        Department department = mapper.reqToEntity(dto);

        return mapper.entityToResp(repository.save(department));
    }

    @Override
    @SneakyThrows
    public RespDepartmentDto get(Long id) {
        Department department = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(id));

        return mapper.entityToResp(department);
    }

}
