package br.com.codenation.centralerros.services;

import br.com.codenation.centralerros.entity.LogSource;
import br.com.codenation.centralerros.exception.MessageException;
import br.com.codenation.centralerros.repository.LogSourceRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class LogSourceService {

    private LogSourceRepository logSourceRepository;

    public List<LogSource> findAll() {
        return logSourceRepository.findAll();
    }

    public LogSource save(LogSource logSource) {
        return logSourceRepository.save(logSource);
    }

    public LogSource findBydId(Long id) throws MessageException {
        if (logSourceRepository.findById(id).isPresent()) {
            return logSourceRepository.findById(id).orElse(null);
        }
        throw new MessageException("LogSource não encontrado!");
    }

    public LogSource update(LogSource logSource) throws MessageException {
        LogSource toUpdate = logSourceRepository.findById(logSource.getId()).orElseThrow(MessageException::new);
        toUpdate.setApplication(logSource.getApplication());
        toUpdate.setServerOrigin(logSource.getServerOrigin());
        toUpdate.setURL(logSource.getURL());

        return logSourceRepository.save(toUpdate);
    }

    public LogSource delete(Long id) {
        LogSource entity = logSourceRepository.findById(id).orElse(null);
        logSourceRepository.delete(entity);
        return entity;
    }

}
