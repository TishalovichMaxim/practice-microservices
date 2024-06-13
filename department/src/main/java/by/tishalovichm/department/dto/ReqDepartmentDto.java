package by.tishalovichm.department.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ReqDepartmentDto {

    private Long id;

    private String departmentName;

    private String departmentDescription;

    private String departmentCode;

}
