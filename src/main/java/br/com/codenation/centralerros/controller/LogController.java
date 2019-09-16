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

    @GetMapping("/{origin}")
    public List<Log> findByServerOrigin(@PathVariable(value = "origin") ServerOrigin origin) {
        return logService.findAllByOrigin(origin);
    }

    @GetMapping("/{orderBy}")
    public List<Log> orderByLevelLog(@PathVariable(value = "orderBy") String orderBy) {
        if (orderBy.equalsIgnoreCase("level")) {
            return logService.orderByLevelLog();
        }
        return logService.findAll(); //TODO: implementar query para buscar por frequência
    }

    @GetMapping("/{level}")
    public List<Log> findByLevel(@PathVariable(value = "level") LevelLog level) {
        return logService.findByLevel(level);
    }

    //TODO: Implementar buscarPorDescrição

    @GetMapping("/{serverOrigin}")
    public List<Log> findByOrigin(@PathVariable(value = "serverOrigin") ServerOrigin origin) {
        return logService.findByServerOrigin(origin);
    }

    @PostMapping
    public Log save(Log log) {
        //log.setCreatedAt(LocalDateTime.now());
        return logService.save(log);
    }

    @PutMapping("/{id}")
    public void toFile(@PathVariable("id") List<Long> id) {
        logService.toFile(id);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable(value = "id") List<Long> id) {
        logService.deleteLog(id);
    }


}
