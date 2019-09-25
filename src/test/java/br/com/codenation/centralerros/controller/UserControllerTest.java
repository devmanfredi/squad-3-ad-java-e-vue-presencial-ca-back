package br.com.codenation.centralerros.controller;


import br.com.codenation.centralerros.dto.entitty.UserDTO;
import br.com.codenation.centralerros.entity.Company;
import br.com.codenation.centralerros.entity.User;
import br.com.codenation.centralerros.entity.UserType;
import br.com.codenation.centralerros.exception.MessageException;
import br.com.codenation.centralerros.mapper.UserMapper;
import br.com.codenation.centralerros.repository.UserRepository;
import br.com.codenation.centralerros.services.UserService;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserControllerTest {

    @Autowired
    private UserController userController;

    @MockBean
    private UserService userService;

    @MockBean
    private UserRepository userRepository;

    private UserMapper userMapper;

    @Test
    public void deveRetornarUmDto() throws MessageException {
        UserDTO userDTO = buildUserDTO(null);
        Mockito.when(userController.save(userDTO)).thenReturn(buildUserDTO(10L));
        UserDTO result = userController.save(userDTO);
        Assert.assertThat(result.getId(), Matchers.equalTo(10L));
    }

    private User buildUser(Long id) {
        return User.builder()
                .id(10L)
                .code("djavue")
                .name("djavue djavue")
                .email("djavue@djavue.com")
                .password("12345")
                .active(true)
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
                .active(true)
                .userType(UserType.ADMIN)
                //.company(Company.builder().id(20L).build())
                .build();
    }


}
