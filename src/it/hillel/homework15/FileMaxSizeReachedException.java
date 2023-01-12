package it.hillel.homework15;

public class FileMaxSizeReachedException extends RuntimeException {

    public FileMaxSizeReachedException(String message) {
        super(message);
    }
}
