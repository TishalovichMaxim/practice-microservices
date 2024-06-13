package by.tishalovichm.department.controller;

import by.tishalovichm.department.dto.ReqDepartmentDto;
import by.tishalovichm.department.dto.RespDepartmentDto;
import by.tishalovichm.department.service.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("v1/departments")
@RequiredArgsConstructor
public class DepartmentController {

    private final DepartmentService service;

    @GetMapping("{id}")
    public ResponseEntity<RespDepartmentDto> get(@PathVariable Long id) {
        return new ResponseEntity<>(
                service.get(id),
                HttpStatus.OK
        );
    }

    @PostMapping("")
    public ResponseEntity<RespDepartmentDto> save(
            @RequestBody ReqDepartmentDto reqDepartmentDto) {

        return new ResponseEntity<>(
                service.save(reqDepartmentDto),
                HttpStatus.CREATED
        );
    }

}
