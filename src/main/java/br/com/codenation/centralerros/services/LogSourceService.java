package br.com.codenation.centralerros.services;

import br.com.codenation.centralerros.entity.LogSource;
import br.com.codenation.centralerros.exception.MessageException;
import br.com.codenation.centralerros.repository.LogSourceRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class LogSourceService {

    private LogSourceRepository logSourceRepository;

    public LogSource save(LogSource logSource) {
        return logSourceRepository.save(logSource);
    }

    public LogSource update(LogSource logSource) throws MessageException {
        LogSource toUpdate = logSourceRepository.findById(logSource.getId()).orElseThrow(MessageException::new);
        toUpdate.setApplication(logSource.getApplication());
        toUpdate.setServerOrigin(logSource.getServerOrigin());

        return logSourceRepository.save(toUpdate);
    }
}
