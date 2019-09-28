package br.com.codenation.centralerros.controller;


import br.com.codenation.centralerros.entity.Application;
import br.com.codenation.centralerros.exception.MessageException;
import br.com.codenation.centralerros.services.ApplicationService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/applications")
public class ApplicationController {

    private ApplicationService appService;

    @PostMapping
    public Application save(@RequestBody Application app) throws MessageException {
        return appService.save(app);
    }

    @GetMapping
    public List<Application> findAll() throws MessageException {
        return appService.findAll();
    }

    @PutMapping
    public Application edit(Long id){
        return null;
    }

    @DeleteMapping
    public void delete(Long id) throws MessageException {
        appService.delete(id);
    }

}
