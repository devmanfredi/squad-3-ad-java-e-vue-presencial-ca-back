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

    public List<Log> findAllByOrigin(ServerOrigin origin) {
        return logRepository.findAllByServerOrigin(origin);
    }

    public List<Log> findByServerOrigin(ServerOrigin origin) {
        return logRepository.findByServerOrigin(origin);
    }

    public List<Log> findByLevel(LevelLog level) {
        return logRepository.findByLevelLog(level);
    }

    public List<Log> orderByLevelLog() {
        return logRepository.findAllByOrderByLevelLogDesc();
    }

    public void toFile(List<Long> id) {
        id.forEach(idLog -> logRepository.toFile(idLog));
    }

    public Log save(Log log) {
        return logRepository.save(log);
    }

    public void deleteLog(List<Long> id) {
        id.forEach(idLog -> logRepository.deleteById(idLog));
    }
}
