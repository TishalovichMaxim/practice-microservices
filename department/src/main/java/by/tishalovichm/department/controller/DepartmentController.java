package by.tishalovichm.department.controller;

import by.tishalovichm.department.dto.ReqDepartmentDto;
import by.tishalovichm.department.dto.RespDepartmentDto;
import by.tishalovichm.department.service.DepartmentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("v1/departments")
@RequiredArgsConstructor
public class DepartmentController {

    private final DepartmentService service;

    @Operation(
            summary = "Get department by id"
    )
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Department found"
                    )
            }
    )
    @GetMapping("{id}")
    public ResponseEntity<RespDepartmentDto> get(@PathVariable Long id) {
        return new ResponseEntity<>(
                service.get(id),
                HttpStatus.OK
        );
    }

    @Operation(
            summary = "Get department by department code"
    )
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Department found"
                    )
            }
    )
    @GetMapping("")
    public ResponseEntity<RespDepartmentDto> get(
            @RequestParam String departmentCode) {

        return new ResponseEntity<>(
                service.get(departmentCode),
                HttpStatus.OK
        );
    }

    @Operation(
            summary = "Create new department"
    )
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "201",
                            description = "Department created"
                    )
            }
    )
    @PostMapping("")
    public ResponseEntity<RespDepartmentDto> save(
            @RequestBody ReqDepartmentDto reqDepartmentDto) {

        return new ResponseEntity<>(
                service.save(reqDepartmentDto),
                HttpStatus.CREATED
        );
    }

}
