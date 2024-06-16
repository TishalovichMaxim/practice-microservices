package by.tishalovichm.organization.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class ReqOrganizationDto {

    private Long id;

    private String name;

    private String description;

    private String code;

    private LocalDateTime creationDate;

}
