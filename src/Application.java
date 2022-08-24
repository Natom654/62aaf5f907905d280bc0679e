public class Application {
    public static void main(String[] args) {
        Dog dog1 = new Dog("Gerry");
        dog1.run(150);
        dog1.swim(15);

        Dog dog2 = new Dog("Berry");
        dog2.run(600);
        dog2.swim(2);

        Dog dog3 = new Dog("Terry");
        dog3.run(90);
        dog3.swim(3);

        Cat cat1 = new Cat("Barsik");
        cat1.run(50);
        cat1.swim(0);

        Cat cat2 = new Cat("Darsik");
        cat2.run(210);
        cat2.swim(10);

       int countanimal = dog1.countdog + cat1.countcat;
        System.out.println("Animals -" + countanimal+ "; Dogs - " + "  " + dog1.countdog + "; Cats -  " + cat1.countcat);
    }
}
