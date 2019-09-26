package br.com.codenation.centralerros.controller;

import br.com.codenation.centralerros.dto.entitty.UserDTO;
import br.com.codenation.centralerros.entity.User;
import br.com.codenation.centralerros.exception.MessageException;
import br.com.codenation.centralerros.services.LoginService;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
@NoArgsConstructor
public class LoginController {

    @Autowired
    private LoginService loginService;
    //private ApplicationService applicationService;
    //private LogService logService;
    //private UserMapper userMapper;

    @GetMapping
    public User login(@RequestBody UserDTO user) throws MessageException {
        //List<Application> applications = applicationService.findAllApplicationsLogin(userWithLoginValidate.getCompany().getId(), userWithLoginValidate.getId());
        //List<Log> logs = logService.findLogsByApplication(userWithLoginValidate.getCompany().getId(), userWithLoginValidate.getId());
        //return loginService.login(user.getCode(), user.getPassword());
        return loginService.login(user);
    }

}
