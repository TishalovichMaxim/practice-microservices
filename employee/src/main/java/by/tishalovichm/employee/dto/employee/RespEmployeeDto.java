package by.tishalovichm.employee.dto.employee;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RespEmployeeDto {

    private Long id;

    private String firstName;

    private String lastName;

    private String email;

    private String departmentCode;

    private String organizationCode;

}
