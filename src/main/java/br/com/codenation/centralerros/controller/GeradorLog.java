package br.com.codenation.centralerros.controller;

import br.com.codenation.centralerros.entity.LevelLog;
import br.com.codenation.centralerros.entity.Log;
import br.com.codenation.centralerros.entity.ServerOrigin;
import br.com.codenation.centralerros.services.LogService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@RestController
@AllArgsConstructor
public class GeradorLog {

    private LogService logService;

    @GetMapping("/gerarLog")
    public void gerarLogs(){
        while(true){

            Log log = new Log();
            log.setTitle("");
            log.setDetails("");
            log.setCollectedBy("");
            log.setServerOrigin(getServerOrigin());
            log.setLevelLog(getLevelLog());


        }
    }

    private LevelLog getLevelLog(){
        Random random = new Random();
        List<LevelLog> levelLogList = new ArrayList<>();
        levelLogList.add(LevelLog.INFO);
        levelLogList.add(LevelLog.TRACE);
        levelLogList.add(LevelLog.DEBUG);
        levelLogList.add(LevelLog.ERROR);
        levelLogList.add(LevelLog.WARNING);
        levelLogList.add(LevelLog.FATAL);
        return levelLogList.get(random.nextInt(5));
    }

    private ServerOrigin getServerOrigin(){
        Random random = new Random();
        List<ServerOrigin> serverOriginList = new ArrayList<>();
        serverOriginList.add(ServerOrigin.DESENVOLVIMENTO);
        serverOriginList.add(ServerOrigin.HOMOLOGACAO);
        serverOriginList.add(ServerOrigin.PRODUCAO);
        return serverOriginList.get(random.nextInt(2));
    }

}
