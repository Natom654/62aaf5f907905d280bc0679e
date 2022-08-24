public class Dog extends Animal {

    public static int countdog = 0;
    public int maxswimdistance = 10;
    public int maxrundistance = 500;

    public Dog(String name) {
        super(name);
        countdog++;
    }

    @Override
    public void run(int rundistance) {
        int restrun = maxrundistance - rundistance;
        if (rundistance > maxrundistance) {
            System.out.println(name + "  can not run so long");
        } else {
            System.out.println(name + " is running " + rundistance + " meters" + ", left to run " + restrun + " meters");
        }
    }

    @Override
    public void swim(int swimdistance) {
        int restswim = maxswimdistance - swimdistance;
        if (swimdistance > maxswimdistance) {
            System.out.println(name + "  can not swim so long");
        } else {
            System.out.println(name + " is swimming " + swimdistance + " meters" + ", left to swim " + restswim + " meters");
        }
    }
}
