package ua.ithillel.homework.race;

public class Cat extends Participant {
    private static int rundistance;
    private static int jumpdistance;

    public Cat(String name, int rundistance, int jumpdistance) {
        super(name);
        this.rundistance = rundistance;
        this.jumpdistance = jumpdistance;
    }

    @Override
    public void jump() {
        System.out.println("Cat  " + super.getName() + "  jump");
    }

    @Override
    public void run() {
        System.out.println("Cat  " + super.getName() + "   run");
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
