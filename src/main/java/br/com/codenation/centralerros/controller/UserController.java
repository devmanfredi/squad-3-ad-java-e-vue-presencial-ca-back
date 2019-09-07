package br.com.codenation.centralerros.controller;

import br.com.codenation.centralerros.entity.Users;
import br.com.codenation.centralerros.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/users")
public class UserController {

    private UserService userService;

    @PostMapping
    public Users save (@RequestBody Users user){
        return userService.save(user);
    }

    @GetMapping
    public List<Users> findAll(){
        return userService.findAll();
    }


}
