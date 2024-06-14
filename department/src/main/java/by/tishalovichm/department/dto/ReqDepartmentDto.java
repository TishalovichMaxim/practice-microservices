package by.tishalovichm.department.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

@Data
@AllArgsConstructor
public class ReqDepartmentDto {

    private Long id;

    @NotBlank
    private String departmentName;

    @NotNull
    @Length(min = 6)
    private String departmentDescription;

    @NotBlank
    private String departmentCode;

}
