package br.com.codenation.centralerros.controller;

import br.com.codenation.centralerros.entity.*;
import br.com.codenation.centralerros.services.LogService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/logs")
public class LogController {

    private LogService logService;

    @GetMapping
    public Page<Log> find(@RequestParam(required = false) Optional<Long> applicationId,
                          @RequestParam(required = false) Optional<Long> companyId,
                          @RequestParam(required = false) Optional<ServerOrigin> origin,
                          @RequestParam(required = false) Optional<LevelLog> levelLog,
                          @RequestParam(required = false) Optional<String> details,
                          @RequestParam(required = false) Optional<Boolean> toFile,
                          @RequestParam(required = false, defaultValue = "0") Integer page,
                          @RequestParam(required = false, defaultValue = "20") Integer size,
                          @RequestParam(required = false, defaultValue = "createdAt") String orderBy,
                          @RequestParam(required = false, defaultValue = "DESC") Sort.Direction direction) {
        return logService.find(applicationId, companyId, origin, levelLog, details, toFile, page, size, orderBy, direction);
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
