package br.com.codenation.centralerros.mapper;

import br.com.codenation.centralerros.dto.entitty.UserDTO;
import br.com.codenation.centralerros.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mappings({
            @Mapping(source = "id", target = "id"),
            @Mapping(source = "code", target = "code"),
            @Mapping(source = "name", target = "name"),
            @Mapping(source = "password", target = "password"),
            @Mapping(source = "email", target = "email"),
            @Mapping(source = "active", target = "active"),
            //@Mapping(source = "company.id", target ="company.id"),
            @Mapping(source = "userType", target = "userType"),
            @Mapping(target = "creationDate", source = ""),
            @Mapping(target = "itensPerPage", source = ""),
            @Mapping(target = "token", source = ""),
            @Mapping(target = "company", source = "")
    })
    User map(UserDTO user);

    UserDTO toDto(User user);

    //User toUserCode(UserCodeDTO userCodeDTO);
    List<User> mapList(List<UserDTO> products);
}
