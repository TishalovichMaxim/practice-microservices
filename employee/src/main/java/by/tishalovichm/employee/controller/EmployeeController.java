package by.tishalovichm.employee.controller;

import by.tishalovichm.employee.dto.employee.ReqEmployeeDto;
import by.tishalovichm.employee.dto.employee.RespEmployeeDto;
import by.tishalovichm.employee.entity.EmployeeAndDepartment;
import by.tishalovichm.employee.service.EmployeeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("v1/employees")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService service;

    @Operation(
            summary = "Get employee by id"
    )
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Employee found"
                    )
            }
    )
    @GetMapping("{id}")
    public ResponseEntity<RespEmployeeDto> get(@PathVariable Long id) {
        return new ResponseEntity<>(
                service.get(id),
                HttpStatus.OK
        );
    }

    @GetMapping("/with_department/{id}")
    public ResponseEntity<EmployeeAndDepartment> getEmployeeWithDepartment(@PathVariable Long id) {
        return new ResponseEntity<>(
                service.getWithDepartment(id),
                HttpStatus.OK
        );
    }

    @Operation(
            summary = "Create new employee"
    )
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "201",
                            description = "Employee created"
                    )
            }
    )
    @PostMapping("")
    public ResponseEntity<RespEmployeeDto> save(
            @RequestBody ReqEmployeeDto reqDepartmentDto) {

        return new ResponseEntity<>(
                service.save(reqDepartmentDto),
                HttpStatus.CREATED
        );
    }

}
