package by.tishalovichm.employee;

import by.tishalovichm.employee.mapper.EmployeeMapper;
import org.mapstruct.factory.Mappers;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class EmployeeApplication {

    @Bean
    public EmployeeMapper mapper() {
        return Mappers.getMapper(EmployeeMapper.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(EmployeeApplication.class, args);
    }

}
