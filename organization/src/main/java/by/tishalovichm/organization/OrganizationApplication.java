package by.tishalovichm.organization;

import by.tishalovichm.organization.mapper.OrganizationMapper;
import org.mapstruct.factory.Mappers;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class OrganizationApplication {

    @Bean
    public OrganizationMapper organizationMapper() {
        return Mappers.getMapper(OrganizationMapper.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(OrganizationApplication.class, args);
    }

}
