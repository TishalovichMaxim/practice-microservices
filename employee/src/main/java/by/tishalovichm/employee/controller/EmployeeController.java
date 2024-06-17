package by.tishalovichm.employee.controller;

import by.tishalovichm.employee.dto.employee.ReqEmployeeDto;
import by.tishalovichm.employee.dto.employee.RespEmployeeDto;
import by.tishalovichm.employee.entity.EmployeeInfo;
import by.tishalovichm.employee.service.EmployeeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(
        name = "Employee Controller",
        description = "Employee controller exposes REST APIs for Employee-Service"
)
@RestController
@RequestMapping("v1/employees")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService service;

    @Operation(
            summary = "Get employee by id",
            description = "Used to retrieve employee from db by id"
    )
    @ApiResponses(
            @ApiResponse(
                    responseCode = "200",
                    description = "Employee found"
            )
    )
    @GetMapping("{id}")
    public ResponseEntity<RespEmployeeDto> get(@PathVariable Long id) {
        return new ResponseEntity<>(
                service.get(id),
                HttpStatus.OK
        );
    }

    @Operation(
            summary = "Get employee with its department and organization by id",
            description = "Used to retrieve employee and its department and organization from db by id"
    )
    @ApiResponses(
            @ApiResponse(
                    responseCode = "200",
                    description = "Employee, department, organization found"
            )
    )
    @GetMapping("{id}/info")
    public ResponseEntity<EmployeeInfo> getEmployeeInfo(@PathVariable Long id) {
        return new ResponseEntity<>(
                service.getInfo(id),
                HttpStatus.OK
        );
    }

    @Operation(
            summary = "Create new employee",
            description = "Used to save new employee to a database"
    )
    @ApiResponses(
            @ApiResponse(
                    responseCode = "201",
                    description = "Employee created"
            )
    )
    @PostMapping("")
    public ResponseEntity<RespEmployeeDto> save(
            @RequestBody @Valid ReqEmployeeDto reqDepartmentDto) {

        return new ResponseEntity<>(
                service.save(reqDepartmentDto),
                HttpStatus.CREATED
        );
    }

}
