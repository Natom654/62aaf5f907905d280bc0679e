package it.hillel.homework15;

import java.io.File;
import java.time.LocalDateTime;

public class FileLoggerConfiguration {
    private String target;
    private LoggingLevel currentLevel;
    private int maxSizeFile;
    private String template = "[%DATE%][%LEVEL%] Message: [%MSG%]";

    public FileLoggerConfiguration(String target, LoggingLevel currentLevel, int maxSizeFile) {
        this.target = target;
        this.currentLevel = currentLevel;
        this.maxSizeFile = maxSizeFile;
    }


    public String getTarget() {
        return target;
    }

    public LoggingLevel getCurrentLevel() {
        return currentLevel;
    }

    public int getMaxSizeFile() {
        return maxSizeFile;
    }

    public String getTemplate() {
        return template;
    }

    protected void setNewFile() {
        configurationParser("FILE");
        target ="target"+"template";
    }

    private void configurationParser(String parameter) {
        String[] splitParameter = parameter.split(": ");
        switch (splitParameter[0]) {
            case "FILE" -> target= "src/main/java/hillel/homeworks/homework20/files/" + LocalDateTime.now();
            case "LEVEL" -> currentLevel=LoggingLevel.valueOf("");
            case "MAX-SIZE" -> maxSizeFile = Integer.parseInt(splitParameter[splitParameter.length - 1]);
            case "FORMAT" -> template = splitParameter[splitParameter.length - 1];
        }
    }

}

