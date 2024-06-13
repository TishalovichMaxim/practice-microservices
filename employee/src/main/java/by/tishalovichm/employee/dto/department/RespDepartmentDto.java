package by.tishalovichm.employee.dto.department;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RespDepartmentDto {

    private Long id;

    private String departmentName;

    private String departmentDescription;

    private String departmentCode;

}
