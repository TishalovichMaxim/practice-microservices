package by.tishalovichm.employee.dto.employee;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;

@Schema(
        description = "Request employee dto model information"
)
@Data
@AllArgsConstructor
public class ReqEmployeeDto {

    private Long id;

    @Schema(
            description = "First name of the employee"
    )
    @NotBlank
    private String firstName;

    @Schema(
            description = "Last name of the employee"
    )
    @NotBlank
    private String lastName;

    @Schema(
            description = "Email of the employee"
    )
    @Email
    @NotBlank
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
