package br.com.codenation.centralerros.controller;

import br.com.codenation.centralerros.entity.User;
import br.com.codenation.centralerros.exception.MessageException;
import br.com.codenation.centralerros.services.UserService;
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

    @PutMapping
    public User edit(User user) {
        return null;
    }

    @DeleteMapping
    public void delete(Long userId){
        userService.delete(userId);
    }
}
