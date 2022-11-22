package ua.ithillel.homework.petrolstation;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class MyPetrolStation {

    private float allFuelOnStation = 100F;
    private static final Semaphore semaphore = new Semaphore(3);
    private ReadWriteLock rwlock = new ReentrantReadWriteLock();

    public void doRefuel(float amountFuel) {
        if (allFuelOnStation > 0 && allFuelOnStation > amountFuel) {
            try {
                semaphore.acquire();
                rwlock.writeLock().lock();
                allFuelOnStation -= amountFuel;
                System.out.println("Filled with  " + amountFuel + " liters");
                System.out.println("On PetrolStation is " + allFuelOnStation + " liters");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                rwlock.writeLock().unlock();
                semaphore.release();
            }
        } else {
            throw new RuntimeException("On station no fuel");
        }
    }
}
