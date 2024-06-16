package by.tishalovichm.employee.mapper;

import by.tishalovichm.employee.dto.organization.ApiOrganizationDto;
import by.tishalovichm.employee.dto.organization.RespOrganizationDto;
import by.tishalovichm.employee.entity.Organization;
import org.mapstruct.Mapper;

@Mapper
public interface OrganizationMapper {

    Organization apiToEntity(ApiOrganizationDto apiOrganizationDto);

    RespOrganizationDto apiToResp(ApiOrganizationDto apiOrganizationDto);

    RespOrganizationDto entityToResp(Organization apiOrganizationDto);

}
