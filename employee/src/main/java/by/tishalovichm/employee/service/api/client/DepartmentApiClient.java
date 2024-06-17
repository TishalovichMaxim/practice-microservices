package by.tishalovichm.employee.service.api.client;

import by.tishalovichm.employee.dto.department.ApiDepartmentDto;
import by.tishalovichm.employee.service.api.client.feign.DepartmentApiFeignClient;
import io.github.resilience4j.retry.annotation.Retry;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DepartmentApiClient {

    private final DepartmentApiFeignClient feignClient;

    @Retry(name = "${microservice.department.name}", fallbackMethod = "getDefaultDepartment")
    public ApiDepartmentDto get(String code) {
        return feignClient.get(code);
    }

    public ApiDepartmentDto getDefaultDepartment(String code, Exception e) {
        return null;
    }

}
