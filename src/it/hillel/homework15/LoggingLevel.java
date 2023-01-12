package it.hillel.homework15;

public enum LoggingLevel {
    DEBUG(2),
    INFO(1),
    ;

    private final int order;

    LoggingLevel(int order) {
        this.order = order;
    }

    public int order() {
        return order;
    }
}
