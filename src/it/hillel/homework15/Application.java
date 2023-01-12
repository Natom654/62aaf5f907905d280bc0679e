package it.hillel.homework15;

public class Application {
    public static void main(String[] args) {

        FileLogger fileLogger = new FileLogger(
                new FileLoggerConfiguration("src/it/hillel/homework15/text.txt", LoggingLevel.INFO, 200));

        fileLogger.info("hello");
        fileLogger.debug("hello5");

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        fileLogger.info("hello");
        fileLogger.info("hello");
        fileLogger.debug("hello");

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
