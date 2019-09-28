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

//    @GetMapping
//    public List<Log> findAllByServerOrigin(@RequestParam(value = "serverOrigin") String serverOrigin) {
//        return logService.findAllByServerOrigin(serverOrigin);
//    }
//
//    @GetMapping
//    public List<Log> findAllByServerOriginOrderByLevelLogDesc(@RequestParam(value = "origin") String origin, @RequestParam(value = "orderBy") String orderBy) {
//        if (orderBy.equalsIgnoreCase("orderByLevel")) {
//            return logService.findAllByServerOriginOrderByLevelLogDesc(origin);
//        }
//        //TODO: implementar query para ordenar por frequência
//        return logService.findAllByServerOrigin(origin);
//    }
//
//    @GetMapping("/search/{filter}/{value}")
//    public List<Log> findBySearchBar(@PathVariable(value = "filter") String filter, @PathVariable(value = "value") String value) {
//        if (filter.equalsIgnoreCase("level")) {
//            return logService.findByLevel(value);
//        }
////        if (filter.equalsIgnoreCase("description")) {
////            //TODO: implementar findByDescription
////        }
//        if (filter.equalsIgnoreCase("origin")) {
//            return logService.findByServerOrigin(value);
//        }
//        return logService.findAll();
//    }

    @GetMapping
    public Page<Log> find(@RequestParam(required = false) Optional<Long> applicationId,
                          @RequestParam(required = false) Optional<Long> companyId,
                          @RequestParam(required = false) Optional<ServerOrigin> origin,
                          @RequestParam(required = false) Optional<LevelLog> levelLog,
                          @RequestParam(required = false, defaultValue = "0") Integer page,
                          @RequestParam(required = false, defaultValue = "20") Integer size,
                          @RequestParam(required = false, defaultValue = "createdAt") String orderBy,
                          @RequestParam(required = false, defaultValue = "DESC") Sort.Direction direction) {
        return logService.find(applicationId, companyId, origin, levelLog, page, size, orderBy, direction);
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
