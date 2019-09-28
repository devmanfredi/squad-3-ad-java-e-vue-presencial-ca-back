package br.com.codenation.centralerros.controller;

import br.com.codenation.centralerros.entity.LevelLog;
import br.com.codenation.centralerros.entity.Log;
import br.com.codenation.centralerros.entity.LogSource;
import br.com.codenation.centralerros.entity.ServerOrigin;
import br.com.codenation.centralerros.services.LogService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@RestController
@AllArgsConstructor
public class GeradorLog {

    private LogService logService;

    @GetMapping("/gerarLog")
    public void gerarLogs() throws InterruptedException {
        while (true) {
            String titleLog = getTitleLog();
            Log log = new Log();
            log.setTitle(titleLog);
            log.setDetails(getDetails(titleLog));
            log.setServerOrigin(getServerOrigin());
            log.setLevelLog(getLevelLog());
            log.setCreatedAt(LocalDateTime.now());
            logService.save(log);
            Thread.sleep(15000);
        }
    }

    private LevelLog getLevelLog() {
        Random random = new Random();
        List<LevelLog> levelLogList = new ArrayList<>();
        levelLogList.add(LevelLog.INFO);
        levelLogList.add(LevelLog.TRACE);
        levelLogList.add(LevelLog.DEBUG);
        levelLogList.add(LevelLog.ERROR);
        levelLogList.add(LevelLog.WARNING);
        levelLogList.add(LevelLog.FATAL);
        return levelLogList.get(random.nextInt(6));
    }

    private ServerOrigin getServerOrigin() {
        Random random = new Random();
        List<ServerOrigin> serverOriginList = new ArrayList<>();
        serverOriginList.add(ServerOrigin.DESENVOLVIMENTO);
        serverOriginList.add(ServerOrigin.HOMOLOGACAO);
        serverOriginList.add(ServerOrigin.PRODUCAO);
        return serverOriginList.get(random.nextInt(3));
    }

    private String getTitleLog() {
        Random random = new Random();
        List<String> stringList = new ArrayList<>();
        stringList.add("Exception");
        stringList.add("RuntimeException");
        stringList.add("ArithmeticException");
        stringList.add("ArrayIndexOutOfBoundsException");
        stringList.add("ArrayStoreException");
        stringList.add("ClassCastException");
        stringList.add("ClassNotFoundException");
        stringList.add("CloneNotSupportedException");
        stringList.add("EnumConstantNotPresentException");
        stringList.add("IllegalAccessException");
        stringList.add("IllegalArgumentException");
        stringList.add("IllegalMonitorStateException");
        stringList.add("IllegalThreadStateException");
        stringList.add("IndexOutBoundsException");
        stringList.add("InstantiationException");
        stringList.add("InterruptedException");
        stringList.add("NegativeArraySizeException");
        stringList.add("NoSuchFieldException");
        stringList.add("NoSuchMethodException");
        stringList.add("NullPointerException");
        stringList.add("NumberFormatException");
        stringList.add("ReflectiveOperationException");
        stringList.add("SecurityException");
        stringList.add("StringIndexOutOfBoundsException");
        stringList.add("TypeNotPresentException");
        stringList.add("UnsupportedOperationException");
        return stringList.get(random.nextInt(25));
    }

    private String getDetails(String titleLog) {
        StringBuilder s = new StringBuilder();
        Random random = new Random();
        s.append("Exception in thread 'main' ").append(titleLog);
        s.append(" at  java.lang.main(").append(titleLog).append(".java:").append(random.nextInt(25)).append(")");
        return s.toString();
    }
}
