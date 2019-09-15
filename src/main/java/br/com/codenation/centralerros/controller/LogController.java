package br.com.codenation.centralerros.controller;

import br.com.codenation.centralerros.entity.Log;
import br.com.codenation.centralerros.services.LogService;
import lombok.AllArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/logs")
public class LogController {

    private LogService logService;

    @GetMapping
    public List<Log> findAll() {
        return logService.findAll();
    }

    @PostMapping
    public Log save(Log log) {
        log.setCreatedAt(LocalDateTime.now());
        return logService.save(log);
    }
}
