package by.tishalovichm.employee.service.api.client.feign;

import by.tishalovichm.employee.dto.department.ApiDepartmentDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "department")
public interface DepartmentApiFeignClient {

    @GetMapping("v1/departments")
    ApiDepartmentDto get(
            @RequestParam("department-code") String departmentCode);

}
