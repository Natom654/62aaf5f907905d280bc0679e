package ua.ithillel.homework.petrolstation;

public class Application {
    public static void main(String[] args) {
        MyPetrolStation myPetrolStation = new MyPetrolStation();

        Runnable refuel = () -> {
            try {
                Thread.currentThread().sleep(10000);
                myPetrolStation.doRefuel(55);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
        Thread firstFuelThread = new Thread(refuel);
        Thread secondFuelThread = new Thread(refuel);
        Thread thirdFuelThread = new Thread(refuel);
        firstFuelThread.start();
        secondFuelThread.start();
        thirdFuelThread.start();

        try {
            firstFuelThread.join();
            secondFuelThread.join();
            thirdFuelThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
