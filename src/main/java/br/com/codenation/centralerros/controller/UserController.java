package br.com.codenation.centralerros.controller;

import br.com.codenation.centralerros.entity.User;
import br.com.codenation.centralerros.exception.MessageException;
import br.com.codenation.centralerros.services.UserService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("/users")
public class UserController {

    private UserService userService;

    @PostMapping
    public User save(User user) throws MessageException {
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
    public void delete(Long userId) {
        userService.delete(userId);
    }
}
