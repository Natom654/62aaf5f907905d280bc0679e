package ua.ithillel.homework.race;

public class Robot extends Participant {
    private static int rundistance;
    private static int jumpdistance;

    public Robot(String name, int rundistance, int jumpdistance) {
        super(name);
        this.rundistance = rundistance;
        this.jumpdistance = jumpdistance;
    }

    @Override
    public void jump() {
        System.out.println("Robot  " + super.getName() + "  jump");
    }

    @Override
    public void run() {
        System.out.println("Robot  " + super.getName() + "   run");
    }

    @Override
    public int rundistance() {
        return rundistance;
    }

    @Override
    public int jumpdistance() {
        return jumpdistance;
    }
}
