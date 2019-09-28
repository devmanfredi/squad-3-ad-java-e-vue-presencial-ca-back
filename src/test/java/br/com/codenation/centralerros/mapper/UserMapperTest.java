package br.com.codenation.centralerros.mapper;

import br.com.codenation.centralerros.dto.entitty.UserDTO;
import br.com.codenation.centralerros.entity.Company;
import br.com.codenation.centralerros.entity.User;
import br.com.codenation.centralerros.entity.UserType;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserMapperTest {

    @MockBean
    private UserMapper userMapper;

    @Test
    public void deveRetornarUserDto() {
        User user = buildUser(null);
        Mockito.when(userMapper.toDto(user)).thenReturn(buildUserDTO(10L));
        UserDTO result = userMapper.toDto(user);
        Assert.assertThat(result.getId(), Matchers.equalTo(10L));
    }


    private User buildUser(Long id) {
        return User.builder()
                .id(10L)
                .code("djavue")
                .name("djavue djavue")
                .email("djavue@djavue.com")
                .password("12345")
                .userType(UserType.ADMIN)
                .company(Company.builder().id(20L).build())
                .creationDate(LocalDateTime.now())
                .itensPerPage(10)
                .token("1029384756")
                .build();
    }

    private UserDTO buildUserDTO(Long id) {
        return UserDTO.builder()
                .id(10L)
                .code("djavue")
                .name("djavue djavue")
                .email("djavue@djavue.com")
                .password("12345")
                .userType(UserType.ADMIN)
                .build();
    }

}
