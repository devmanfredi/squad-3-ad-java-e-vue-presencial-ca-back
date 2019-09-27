package br.com.codenation.centralerros.mapper;

import br.com.codenation.centralerros.dto.entitty.CompanyDTO;
import br.com.codenation.centralerros.entity.Company;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CompanyMapper {

    @Mappings({
            @Mapping(source = "id", target = "id"),
            @Mapping(source = "code", target = "code"),
            @Mapping(source = "name", target = "name"),
            //@Mapping(target = "application.id", source = "apllication.id"),
            @Mapping(target = "application", source = "")
    })
    Company map(CompanyDTO companyDTO);

    CompanyDTO toDto(Company company);

    List<Company> mapList(List<CompanyDTO> products);
}
