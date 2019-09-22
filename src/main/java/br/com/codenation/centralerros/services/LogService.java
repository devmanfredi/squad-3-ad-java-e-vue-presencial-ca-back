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
        return logRepository.save(log);
    }

    public void deleteLog(List<Long> id) {
        id.forEach(idLog -> logRepository.deleteById(idLog));
    }

    public List<Log> findLogsByApplication(Long companyId, Long userId) {
        return logRepository.findLogsByApplicationAndCompanyAndUser(companyId, userId);
    }
}
