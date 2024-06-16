package by.tishalovichm.employee.dto.organization;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class RespOrganizationDto {

    private Long id;

    private String name;

    private String description;

    private String code;

    private LocalDateTime creationDate;

}
