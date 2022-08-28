package ua.ithillel.homework.race;

public interface Obstacle {
    String overcome(Participant participant);

    boolean race(Participant participant);
}
