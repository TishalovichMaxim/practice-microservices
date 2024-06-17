package by.tishalovichm.employee.service.impl;

import by.tishalovichm.employee.dal.EmployeeRepository;
import by.tishalovichm.employee.dto.department.ApiDepartmentDto;
import by.tishalovichm.employee.dto.department.RespDepartmentDto;
import by.tishalovichm.employee.dto.employee.ReqEmployeeDto;
import by.tishalovichm.employee.dto.employee.RespEmployeeDto;
import by.tishalovichm.employee.dto.organization.ApiOrganizationDto;
import by.tishalovichm.employee.dto.organization.RespOrganizationDto;
import by.tishalovichm.employee.entity.Employee;
import by.tishalovichm.employee.entity.EmployeeInfo;
import by.tishalovichm.employee.exception.ApiException;
import by.tishalovichm.employee.exception.ResourceNotFoundException;
import by.tishalovichm.employee.mapper.DepartmentMapper;
import by.tishalovichm.employee.mapper.EmployeeMapper;
import by.tishalovichm.employee.mapper.OrganizationMapper;
import by.tishalovichm.employee.service.api.client.DepartmentApiClient;
import by.tishalovichm.employee.service.api.client.OrganizationApiClient;
import by.tishalovichm.employee.service.EmployeeService;
import feign.FeignException;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeServiceImpl.class);

    private final DepartmentApiClient departmentApiClient;

    private final OrganizationApiClient organizationApiClient;

    private final EmployeeMapper employeeMapper;

    private final DepartmentMapper departmentMapper;

    private final OrganizationMapper organizationMapper;

    private final EmployeeRepository repository;

    private RespDepartmentDto getDepartment(String code) throws ApiException {
        try {
            ApiDepartmentDto apiDepartment = departmentApiClient.get(
                    code
            );

            return departmentMapper.apiToResp(apiDepartment);
        } catch (FeignException e) {
            if (e.status() == HttpStatus.NOT_FOUND.value()) {
                throw new ApiException(
                        String.format(
                                "Department with code=%s not found",
                                code
                        ),
                        HttpStatus.NOT_FOUND
                );
            }

            throw new ApiException(
                    "Error in retrieving department",
                    HttpStatus.INTERNAL_SERVER_ERROR
            );
        }
    }

    private RespOrganizationDto getOrganization(String code) throws ApiException {
        try {
            ApiOrganizationDto apiOrganization = organizationApiClient.get(
                    code
            );

            return organizationMapper.apiToResp(apiOrganization);
        } catch (FeignException e) {
            if (e.status() == HttpStatus.NOT_FOUND.value()) {
                throw new ApiException(
                        String.format(
                                "Organization with code=%s not found",
                                code
                        ),
                        HttpStatus.NOT_FOUND
                );
            }

            throw new ApiException(
                    "Error in retrieving organization",
                    HttpStatus.INTERNAL_SERVER_ERROR
            );
        }
    }

    @Override
    @SneakyThrows
    public RespEmployeeDto save(ReqEmployeeDto dto) {
        try {
            Employee employee = employeeMapper.reqToEntity(dto);
            return employeeMapper.entityToResp(repository.save(employee));
        } catch (DataIntegrityViolationException e) {
            throw new ApiException("Email must be unique");
        }
    }

    @Override
    @SneakyThrows
    public RespEmployeeDto get(Long id) {
        Employee employee = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(id));

        return employeeMapper.entityToResp(employee);
    }

    @SneakyThrows
    @Override
    public EmployeeInfo getInfo(Long id) {
        Employee employee = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(id));

        RespDepartmentDto department = getDepartment(
                employee.getDepartmentCode()
        );

        RespOrganizationDto organization = getOrganization(
                employee.getOrganizationCode()
        );

        return new EmployeeInfo(
                employeeMapper.entityToResp(employee),
                department,
                organization
        );
    }

}
