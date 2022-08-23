public class Dog extends Animal {

    protected static int countdog = 0;
    protected int maxswimdistance = 10;
    protected int maxrundistance = 500;

    public Dog(String name) {
        super(name);
        countdog++;
    }

    @Override
    public void run(int rundistance) {
        int restrun = maxrundistance - rundistance;
        if (rundistance > maxrundistance) {
            System.out.println(name + "  can not run so long");
        } else
            System.out.println(name + " is running " + rundistance + " meters" + ", left to run " + restrun + " meters");
    }

    @Override
    public void swim(int swimdistance) {
        int restswim = maxswimdistance - swimdistance;
        if (swimdistance > maxswimdistance) {
            System.out.println(name + "  can not swim so long");
        } else
            System.out.println(name + " is swimming " + swimdistance + " meters" + ", left to swim " + restswim + " meters");
    }

}
