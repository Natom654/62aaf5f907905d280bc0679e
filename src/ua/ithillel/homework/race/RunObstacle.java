package ua.ithillel.homework.race;

public class RunObstacle implements Obstacle {
    private String title;
    private int length;

    public RunObstacle(String title, int length) {
        this.title = title;
        this.length = length;
    }

    @Override
    public String overcome(Participant participant) {
        return (participant.getName() + " run  " + title);
    }

    public boolean race(Participant participant) {
        if (length <= participant.rundistance()) {
            System.out.println(participant.getName() + " run " + participant.rundistance() + " meters of " + title);
            return true;
        } else {
            System.out.println(participant.getName() + " does not run " + length + " meters of " + title + " .He run only " + participant.rundistance());
        }
        return false;
    }
}
