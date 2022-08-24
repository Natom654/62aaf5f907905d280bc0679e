public class Cat extends Animal {

    public static int countcat = 0;
    public  int maxrundistance = 200;

    public Cat(String name) {
        super(name);
        countcat++;
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
        System.out.println(name + " can not swim ");
    }
}
