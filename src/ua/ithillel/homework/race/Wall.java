package ua.ithillel.homework.race;

public class Wall implements Obstacle {
    private String title;
    private int hight;

    public Wall(String title, int hight) {
        this.title = title;
        this.hight = hight;
    }

    @Override
    public String overcome(Participant participant) {
        return (participant.getName() + " jump  " + title);
    }

    public boolean race(Participant participant) {
        if (hight <= participant.jumpdistance()) {
            System.out.println(participant.getName() + " jump " + participant.jumpdistance() + "meters of " + title);
            return true;
        } else {
            System.out.println(participant.getName() + " does not jump " + hight + "meters of " + title + " .He jump only " + participant.rundistance());
        }
        return false;
    }
}