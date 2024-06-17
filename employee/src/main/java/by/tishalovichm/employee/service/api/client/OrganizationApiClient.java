package by.tishalovichm.employee.service.api.client;

import by.tishalovichm.employee.dto.organization.ApiOrganizationDto;
import by.tishalovichm.employee.service.api.client.feign.OrganizationApiFeignClient;
import io.github.resilience4j.retry.annotation.Retry;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class OrganizationApiClient {

    private final OrganizationApiFeignClient feignClient;

    @Retry(name = "${microservice.organization.name}", fallbackMethod = "getDefaultOrganization")
    public ApiOrganizationDto get(String code) {
        return feignClient.get(code);
    }

    public ApiOrganizationDto getDefaultOrganization(String code, Exception e) {
        return null;
    }

}
