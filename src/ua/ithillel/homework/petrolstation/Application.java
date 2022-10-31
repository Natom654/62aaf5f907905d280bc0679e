package ua.ithillel.homework.petrolstation;

public class Application {
    public static void main(String[] args) throws FuelNotFoundException {
        MyPetrolStation myPetrolStation = new MyPetrolStation();
        Thread firstFuelThread = new Thread(String.valueOf(myPetrolStation.doRefuel(10)));
        Thread secondFuelThread = new Thread(String.valueOf(myPetrolStation.doRefuel(20)));
        Thread thirdFuelThread = new Thread(String.valueOf(myPetrolStation.doRefuel(145)));
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
