package br.com.codenation.centralerros.controller;

import br.com.codenation.centralerros.entity.Application;
import br.com.codenation.centralerros.entity.Log;
import br.com.codenation.centralerros.entity.User;
import br.com.codenation.centralerros.exception.MessageException;
import br.com.codenation.centralerros.services.ApplicationService;
import br.com.codenation.centralerros.services.LogService;
import br.com.codenation.centralerros.services.LoginService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/login")
public class LoginController {

    private LoginService loginService;
    private ApplicationService applicationService;
    private LogService logService;

    @GetMapping
    public List<Log> login(@RequestBody User user) throws MessageException {
        User userWithLoginValidate = loginService.login(user.getCode(), user.getPassword());
        List<Application> applications = applicationService.findAllApplicationsLogin(userWithLoginValidate.getCompany().getId(), userWithLoginValidate.getId());
        List<Log> logs = logService.findLogsByApplication(userWithLoginValidate.getCompany().getId(), userWithLoginValidate.getId());
        //return loginService.login(user.getCode(), user.getPassword());

        return Collections.emptyList();
    }
}
