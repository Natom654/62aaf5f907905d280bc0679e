package it.hillel.homework15;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

public class FileLogger implements Logger {

    private final FileLoggerConfiguration configuration;
    private String time;

    public FileLogger(FileLoggerConfiguration configuration) {
        this.configuration = configuration;
    }

    @Override
    public void info(String message) {
        if (configuration.getCurrentLevel().order() < LoggingLevel.INFO.order()) return;
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(configuration.getTarget(), true))) {
            writer.write(String.format(configuration.getTemplate(), new Date(), LoggingLevel.INFO,message));
            writer.newLine();
        } catch (IOException ex) {
            ex.printStackTrace();
            throw new RuntimeException(String.format(
                    "Something went wrong during writing log",
                    LoggingLevel.INFO,
                    configuration.getTarget()
            ));
        }
    }

    @Override
    public void debug(String message) {
        if (configuration.getCurrentLevel().order() < LoggingLevel.DEBUG.order()) return;
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(configuration.getTarget(), true))) {
            writer.write(String.format(configuration.getTemplate(), new Date(), LoggingLevel.DEBUG,message));
            writer.newLine();
        } catch (IOException ex) {
            ex.printStackTrace();
            throw new RuntimeException(String.format(
                    "Something went wrong during writing log",
                    LoggingLevel.DEBUG,
                    configuration.getTarget()
            ));
        }
    }

    private void write(String message) {
        checkFileSize(message);


        try (BufferedWriter bw = new BufferedWriter(new FileWriter(configuration.getTemplate(), true))) {
            bw.write(message);
            bw.newLine();
            bw.flush();
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }

    private void checkFileSize(String message) {
        long fileSize = configuration.getTemplate().length() + message.getBytes().length + 1;
        if (fileSize >= configuration.getMaxSizeFile()) {
            try {
                throw new FileMaxSizeReachedException(
                        "File size limit is reached. File size limit: " + configuration.getMaxSizeFile()
                                + " bytes; Current file size: " + fileSize
                                + " bytes; File path: " + configuration.getTemplate()
                );
            } catch (FileMaxSizeReachedException ex) {
                System.out.println(ex.getMessage());
            }
            configuration.setNewFile();
        }
    }



}
