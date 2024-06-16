package by.tishalovichm.employee.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class Organization {

    private Long id;

    private String name;

    private String description;

    private String code;

    private LocalDateTime creationDate;

}
