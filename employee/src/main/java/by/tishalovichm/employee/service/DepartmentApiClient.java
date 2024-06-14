package by.tishalovichm.employee.service;

import by.tishalovichm.employee.dto.department.ApiDepartmentDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(url = "http://localhost:8080", name = "department-client")
public interface DepartmentApiClient {

    @GetMapping("v1/departments")
    ApiDepartmentDto get(
            @RequestParam("department-code") String departmentCode);

}
