package by.tishalovichm.employee.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Department {

    private Long id;

    private String departmentName;

    private String departmentDescription;

    private String departmentCode;

}
