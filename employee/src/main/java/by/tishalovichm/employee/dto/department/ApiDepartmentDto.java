package by.tishalovichm.employee.dto.department;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;

@Schema(
        description = "Information about department dto model, that is retrieved from api call"
)
@Data
@AllArgsConstructor
public class ApiDepartmentDto {

    private Long id;

    @Schema(
            description = "Department name"
    )
    private String departmentName;

    @Schema(
            description = "Department description"
    )
    private String departmentDescription;

    @Schema(
            description = "Department code"
    )
    private String departmentCode;

}
