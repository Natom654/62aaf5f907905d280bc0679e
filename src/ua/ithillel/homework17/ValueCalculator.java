package ua.ithillel.homework17;

public class ValueCalculator implements Runnable {
    private static int[] mainArray;
    private static int arraylength = 2000000;
    private static int halflength = arraylength / 2;

    public static void doCalc() {
        long startTime = System.currentTimeMillis();
        mainArray = new int[arraylength];
        for (int i = 0; i < arraylength; i++) {
            mainArray[i] = 1;
        }
        int[] array1 = new int[halflength];
        int[] array2 = new int[halflength];
        float[] arrayf2 = new float[halflength];
        float[] arrayf1 = new float[halflength];
        System.arraycopy(mainArray, 0, array1, 0, halflength);
        System.arraycopy(mainArray, halflength, array2, 0, halflength);

        // поток 1
        Runnable task1 = () -> {
            for (int i = 0; i < halflength; i++) {
                arrayf1[i] = (float) (array1[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
            }
        };
        Thread thread1 = new Thread(task1);
        thread1.start();
        try {
            thread1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // поток 2
        Runnable task2 = () -> {
            for (int i = 0; i < halflength; i++) {
                arrayf2[i] = (float) (array2[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
            }
        };
        Thread thread2 = new Thread(task2);
        thread2.start();
        try {
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // склейка массивов
        float[] arrayfmain = new float[arraylength];
        System.arraycopy(arrayf1, 0, arrayfmain, 0, halflength);
        System.arraycopy(arrayf2, 0, arrayfmain, halflength, halflength);

        //- Вычислить затраченное время от старта до завершения программы и вывод его в консоль
        long alltime = System.currentTimeMillis() - startTime;
        System.out.println("The programm was continue  " + alltime + " millisec");
    }

    @Override
    public void run() {
    }
}


