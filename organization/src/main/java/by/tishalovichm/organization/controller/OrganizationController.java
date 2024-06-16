package by.tishalovichm.organization.controller;

import by.tishalovichm.organization.dto.ReqOrganizationDto;
import by.tishalovichm.organization.dto.RespOrganizationDto;
import by.tishalovichm.organization.service.OrganizationService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("v1/organizations")
@RequiredArgsConstructor
public class OrganizationController {

    private final OrganizationService service;

    @GetMapping("{id}")
    public ResponseEntity<RespOrganizationDto> get(@PathVariable Long id) {
        return ResponseEntity.ok(service.get(id));
    }

    @GetMapping("")
    public ResponseEntity<RespOrganizationDto> get(@RequestParam String code) {
        return ResponseEntity.ok(service.get(code));
    }

    @PostMapping
    public ResponseEntity<RespOrganizationDto> get(
            @RequestBody @Valid ReqOrganizationDto organization) {

        return new ResponseEntity<>(
                service.save(organization),
                HttpStatus.CREATED
        );
    }

}
