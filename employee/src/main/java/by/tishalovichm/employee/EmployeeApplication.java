package by.tishalovichm.employee;

import by.tishalovichm.employee.mapper.DepartmentMapper;
import by.tishalovichm.employee.mapper.EmployeeMapper;
import org.mapstruct.factory.Mappers;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
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
    public WebClient webClient() {
        return WebClient.builder()
                .build();
    }

    public static void main(String[] args) {
        SpringApplication.run(EmployeeApplication.class, args);
    }

}
