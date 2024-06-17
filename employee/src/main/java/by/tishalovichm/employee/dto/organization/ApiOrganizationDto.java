package by.tishalovichm.employee.dto.organization;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Schema(
        description = "Information about organization dto model, that is retrieved from api call"
)
@Data
@AllArgsConstructor
public class ApiOrganizationDto {

    private Long id;

    @Schema(
            description = "Name of the organization"
    )
    private String name;

    @Schema(
            description = "Description of the organization"
    )
    private String description;

    @Schema(
            description = "Code of the organization"
    )
    private String code;

    @Schema(
            description = "Creation date of the organization"
    )
    private LocalDateTime creationDate;

}
