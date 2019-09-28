package br.com.codenation.centralerros.controller;


import br.com.codenation.centralerros.dto.entitty.UserDTO;
import br.com.codenation.centralerros.entity.Company;
import br.com.codenation.centralerros.entity.User;
import br.com.codenation.centralerros.entity.UserType;
import br.com.codenation.centralerros.exception.MessageException;
import br.com.codenation.centralerros.mapper.UserMapper;
import br.com.codenation.centralerros.repository.LoginRepository;
import br.com.codenation.centralerros.repository.UserRepository;
import br.com.codenation.centralerros.services.LoginService;
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

    @Autowired
    private LoginController loginController;

    @MockBean
    private UserService userService;
    @MockBean
    private UserRepository userRepository;

    @MockBean
    private LoginService loginService;
    @MockBean
    private LoginRepository loginRepository;

    private UserMapper userMapper;

    @Test
    public void deveRetornarUmUserDto() throws MessageException {
        UserDTO userDTO = buildUserDTO(null);
        Mockito.when(userController.save(userDTO)).thenReturn(buildUserDTO(10L));
        UserDTO result = userController.save(userDTO);
        Assert.assertThat(result.getId(), Matchers.equalTo(10L));
    }

    @Test
    public void deveRetornarUserLogado() throws MessageException {
        UserDTO user = buildUserDTO(null);
        Mockito.when(loginController.login(user)).thenReturn(buildUser(10L));
        User result = loginController.login(user);
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
