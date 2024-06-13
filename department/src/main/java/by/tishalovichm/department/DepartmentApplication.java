package by.tishalovichm.department;

import by.tishalovichm.department.mapper.DepartmentMapper;
import org.mapstruct.factory.Mappers;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DepartmentApplication {

    @Bean
    public DepartmentMapper mapper() {
        return Mappers.getMapper(DepartmentMapper.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(DepartmentApplication.class, args);
    }

}
