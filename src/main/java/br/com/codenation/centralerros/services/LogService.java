package br.com.codenation.centralerros.services;

import br.com.codenation.centralerros.entity.*;
import br.com.codenation.centralerros.repository.LogRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class LogService {

    private LogRepository logRepository;

    public void toFile(List<Long> id) {
        id.forEach(idLog -> logRepository.toFile(idLog));
    }

    public Log save(Log log) {
        return logRepository.saveAndFlush(log);
    }

    public void deleteLog(List<Long> id) {
        id.forEach(idLog -> logRepository.deleteById(idLog));
    }

    public Page<Log> find(Optional<Long> applicationId, Optional<Long> companyId, Optional<ServerOrigin> origin, Optional<LevelLog> levelLog, Optional<String> details, Optional<Boolean> toFile, Integer page, Integer size, String orderBy, Sort.Direction direction) {


        Log log = Log.builder()
                .application(applicationId.map(id -> Application.builder().id(id).build()).orElse(null))
                .company(companyId.map(id -> Company.builder().id(id).build()).orElse(null))
                .serverOrigin(origin.orElse(null))
                .levelLog(levelLog.orElse(null))
                .details(details.orElse(null))
                .toFile(toFile.orElse(null))
                .build();
        return logRepository.findAll(Example.of(log, containsIgnoreCase("details")),
                PageRequest.of(page, size, Sort.by(direction, orderBy)));
    }

    private ExampleMatcher containsIgnoreCase(String keyWord) {
        return ExampleMatcher
                .matchingAll()
                .withMatcher(keyWord, ExampleMatcher.GenericPropertyMatchers.contains().ignoreCase());
    }
}