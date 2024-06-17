package by.tishalovichm.employee.dto.employee;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;

@Schema(
        description = "Response employee dto model information"
)
@Data
@AllArgsConstructor
public class RespEmployeeDto {

    private Long id;

    @Schema(
            description = "First name of the employee"
    )
    private String firstName;

    @Schema(
            description = "Last name of the employee"
    )
    private String lastName;

    @Schema(
            description = "Email of the employee"
    )
    private String email;

    @Schema(
            description = "Code of the employee department"
    )
    private String departmentCode;

    @Schema(
            description = "Code of the employee organization"
    )
    private String organizationCode;

}
