package by.tishalovichm.employee;

import by.tishalovichm.employee.mapper.DepartmentMapper;
import by.tishalovichm.employee.mapper.EmployeeMapper;
import by.tishalovichm.employee.mapper.OrganizationMapper;
import org.mapstruct.factory.Mappers;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableFeignClients
public class EmployeeApplication {

    @Bean
    public EmployeeMapper employeeMapper() {
        return Mappers.getMapper(EmployeeMapper.class);
    }

    @Bean
    public DepartmentMapper departmentMapper() {
        return Mappers.getMapper(DepartmentMapper.class);
    }

    @Bean
    public OrganizationMapper organizationMapper() {
        return Mappers.getMapper(OrganizationMapper.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(EmployeeApplication.class, args);
    }

}
