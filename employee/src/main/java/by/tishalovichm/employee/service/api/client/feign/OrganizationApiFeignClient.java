package by.tishalovichm.employee.service.api.client.feign;

import by.tishalovichm.employee.dto.organization.ApiOrganizationDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(url = "http://localhost:8083", name = "${microservice.organization.name}")
public interface OrganizationApiFeignClient {

    @GetMapping("v1/organizations")
    ApiOrganizationDto get(
            @RequestParam String code);

}
