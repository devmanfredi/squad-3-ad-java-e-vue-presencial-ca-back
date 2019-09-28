package br.com.codenation.centralerros.controller;

import br.com.codenation.centralerros.entity.LogSource;
import br.com.codenation.centralerros.exception.MessageException;
import br.com.codenation.centralerros.services.LogSourceService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/logsource")
public class LogSourceController {

    private LogSourceService logSourceService;

    @GetMapping
    public List<LogSource> findAll() {
        return logSourceService.findAll();
    }

    @PostMapping
    public LogSource save(@RequestBody LogSource logSource) {
        return logSourceService.save(logSource);
    }

    @PutMapping
    public LogSource update(@RequestBody LogSource logSource) throws MessageException {
        return logSourceService.update(logSource);
    }


}
