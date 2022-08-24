public abstract class Animal {
    public String name;

    public Animal(String name) {
        this.name = name;
    }

    public abstract void run(int rundistance);

    public abstract void swim(int swimdistance);
}

