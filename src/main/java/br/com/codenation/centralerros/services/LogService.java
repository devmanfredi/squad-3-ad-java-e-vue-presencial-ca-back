package br.com.codenation.centralerros.services;

import br.com.codenation.centralerros.entity.Log;
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

    public Log save(Log log) {
        return logRepository.save(log);
    }
}
