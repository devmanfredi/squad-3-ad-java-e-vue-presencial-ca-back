package br.com.codenation.centralerros.services;

import br.com.codenation.centralerros.entity.*;
import br.com.codenation.centralerros.repository.LogRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class LogService {

    private LogRepository logRepository;

    public List<Log> findAll() {
        return logRepository.findAll();
    }

    public List<Log> findAllByServerOrigin(String serverOrigin) {
        return logRepository.findAllByServerOriginAndToFileFalse(ServerOrigin.valueOf(serverOrigin.toUpperCase()));
    }

    public List<Log> findByServerOrigin(String serverOrigin) {
        return logRepository.findByServerOriginAndToFileFalse(ServerOrigin.valueOf(serverOrigin.toUpperCase()));
    }

    public List<Log> findByLevel(String level) {
        return logRepository.findByLevelLogAndToFileFalse(LevelLog.valueOf(level.toUpperCase()));
    }

    public List<Log> orderByLevelLog() {
        return logRepository.findAllByToFileFalseOrderByLevelLogDesc();
    }

    public List<Log> findAllByServerOriginOrderByLevelLogDesc(String serverOrigin) {

        return logRepository.findAllByServerOriginAndToFileFalseOrderByLevelLogDesc(ServerOrigin.valueOf(serverOrigin.toUpperCase()));
    }

    public void toFile(List<Long> id) {
        id.forEach(idLog -> logRepository.toFile(idLog));
    }

    public Log save(Log log) {
        return logRepository.saveAndFlush(log);
    }

    public void deleteLog(List<Long> id) {
        id.forEach(idLog -> logRepository.deleteById(idLog));
    }

    public List<Log> findLogsByApplication(Long companyId, Long userId) {
        return logRepository.findLogsByApplicationAndCompanyAndUser(companyId, userId);
    }

    public Page<Log> find(Optional<Long> applicationId, Optional<Long> companyId, Optional<ServerOrigin> origin, Optional<LevelLog> levelLog, Integer page, Integer size, String orderBy, Sort.Direction direction) {
        Log log = Log.builder()
                .application(applicationId.map(id -> Application.builder().id(id).build()).orElse(null))
                .company(companyId.map(id -> Company.builder().id(id).build()).orElse(null))
                .serverOrigin(origin.orElse(null))
                .levelLog(levelLog.orElse(null))
                .build();
        return logRepository.findAll(Example.of(log), PageRequest.of(page, size, Sort.by(direction, orderBy)));
    }
}
