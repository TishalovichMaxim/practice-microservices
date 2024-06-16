package by.tishalovichm.organization.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class ReqOrganizationDto {

    private Long id;

    @NotBlank
    private String name;

    private String description;

    @NotBlank
    private String code;

    private LocalDateTime creationDate;

}
