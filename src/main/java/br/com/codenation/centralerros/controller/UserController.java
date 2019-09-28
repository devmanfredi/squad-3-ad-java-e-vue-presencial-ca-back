package br.com.codenation.centralerros.controller;

import br.com.codenation.centralerros.dto.entitty.UserCodeDTO;
import br.com.codenation.centralerros.dto.entitty.UserDTO;
import br.com.codenation.centralerros.entity.User;
import br.com.codenation.centralerros.exception.MessageException;
import br.com.codenation.centralerros.services.UserService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public UserDTO save(@RequestBody UserDTO user) throws MessageException {
        return userService.save(user);
    }

    @GetMapping
    public List<User> findAll() {
        return userService.findAll();
    }

    @ApiImplicitParams({
            @ApiImplicitParam(name = "Authorization", required = true, paramType = "header")
    })

    @PutMapping
    public User edit(User user) {
        return null;
    }

    @DeleteMapping
    public void delete(Long userId) throws MessageException {
        userService.delete(userId);
    }

    @GetMapping("/validate")
    public String validate(@RequestBody UserCodeDTO userCode) {
        return userService.validateCode(userCode.getCode());
    }
}
