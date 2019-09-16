package br.com.codenation.centralerros.controller;

import br.com.codenation.centralerros.entity.LevelLog;
import br.com.codenation.centralerros.entity.Log;
import br.com.codenation.centralerros.entity.ServerOrigin;
import br.com.codenation.centralerros.services.LogService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/{origin}")
    public List<Log> findByOrigin(@PathVariable(value = "origin") ServerOrigin origin) {
        return logService.findByOrigin(origin);
    }

    @GetMapping("/{level}")
    public List<Log> findByLevel(@PathVariable(value = "level") LevelLog level) {
        return logService.findByLevel(level);
    }

    @GetMapping
    public List<Log> orderByLevelLog() {
        return logService.orderByLevelLog();
    }

    @PostMapping
    public Log save(Log log) {
        //log.setCreatedAt(LocalDateTime.now());
        return logService.save(log);
    }
}
