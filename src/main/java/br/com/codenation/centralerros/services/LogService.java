package br.com.codenation.centralerros.services;

import br.com.codenation.centralerros.entity.LevelLog;
import br.com.codenation.centralerros.entity.Log;
import br.com.codenation.centralerros.entity.ServerOrigin;
import br.com.codenation.centralerros.repository.LogRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class LogService {

    private LogRepository logRepository;

    public List<Log> findAll() {
        return logRepository.findAll();
    }

    public List<Log> findByOrigin(ServerOrigin origin) {
        return logRepository.findByServerOrigin(origin);
    }

    public List<Log> findByLevel(LevelLog level) {
        return logRepository.findByLevelLog(level);
    }

    public Log save(Log log) {
        return logRepository.save(log);
    }
}
