package ua.ithillel.homework.petrolstation;

public class MyPetrolStation implements PetrolStation, Runnable {
    private float allFuelOnStation;

    private final Object lock = new Object();

    public MyPetrolStation() {
        this.allFuelOnStation = 100;
    }

    @Override
    public synchronized float doRefuel(float amountFuel) throws FuelNotFoundException {
        if (allFuelOnStation > 0 && allFuelOnStation> amountFuel) {
            synchronized (lock) {
                System.out.println("Filled with " + amountFuel + " liters");
                allFuelOnStation = allFuelOnStation - amountFuel;
                System.out.println("On PetrolStation " + allFuelOnStation + " liters");
                notify();
                return allFuelOnStation;
            }
        } else {
            throw new FuelNotFoundException("On station no fuel");
        }
    }

    public synchronized void run() {
        for (int i = 1; i <= 3; i++) {
            try {
                Thread.sleep(10000);
            } catch (Exception e) {
                System.out.println(e);
            }
            System.out.println(i);
        }
    }
}
