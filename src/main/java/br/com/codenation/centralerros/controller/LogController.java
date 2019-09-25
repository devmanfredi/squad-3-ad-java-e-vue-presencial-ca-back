package br.com.codenation.centralerros.controller;

import br.com.codenation.centralerros.entity.LevelLog;
import br.com.codenation.centralerros.entity.Log;
import br.com.codenation.centralerros.entity.ServerOrigin;
import br.com.codenation.centralerros.services.LogService;
import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/logs")
public class LogController {

    private LogService logService;

    @GetMapping
    public List<Log> findAllByServerOrigin(@RequestParam(value = "serverOrigin") String serverOrigin) {
        return logService.findAllByServerOrigin(serverOrigin);
    }

    @GetMapping("/{origin}/{orderBy}")
    public List<Log> findAllByServerOriginOrderByLevelLogDesc(@PathVariable(value = "origin") String origin, @PathVariable(value = "orderBy") String orderBy) {
        if (orderBy.equalsIgnoreCase("orderByLevel")) {
            return logService.findAllByServerOriginOrderByLevelLogDesc(origin);
        }
        //TODO: implementar query para ordenar por frequência
        return logService.findAllByServerOrigin(origin);
    }

    @GetMapping("/search/{filter}/{value}")
    public List<Log> findBySearchBar(@PathVariable(value = "filter") String filter, @PathVariable(value = "value") String value) {
        if (filter.equalsIgnoreCase("level")) {
            return logService.findByLevel(value);
        }
//        if (filter.equalsIgnoreCase("description")) {
//            //TODO: implementar findByDescription
//        }
        if (filter.equalsIgnoreCase("origin")) {
            return logService.findByServerOrigin(value);
        }
        return logService.findAll();
    }

    @PutMapping("/file/{id}")
    public void toFile(@PathVariable("id") List<Long> id) {
        logService.toFile(id);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable(value = "id") List<Long> id) {
        logService.deleteLog(id);
    }
}
