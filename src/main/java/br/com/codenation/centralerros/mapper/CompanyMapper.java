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
    })
    CompanyDTO map(Company company);

    List<CompanyDTO> mapList(List<Company> products);
}
