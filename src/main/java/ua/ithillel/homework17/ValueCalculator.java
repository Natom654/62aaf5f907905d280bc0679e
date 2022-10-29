package ua.ithillel.homework17;

public class ValueCalculator implements Runnable {
    private static int[] valuesForCalculation;
    private static int mainArraylength = 2000000;
    private static int halfLength = mainArraylength / 2;

    @Override
    public void run() {
        System.out.println("Thread run");
    }

    public static void doCalc() {
        long startTimeTask = System.currentTimeMillis();
        valuesForCalculation = new int[mainArraylength];
        for (int i = 0; i < mainArraylength; i++) {
            valuesForCalculation[i] = 1;
        }
        int[] valuesPartOne = new int[halfLength];
        int[] valuesPartTwo = new int[halfLength];
        float[] valuesFloatPartOne = new float[halfLength];
        float[] valuesFloatPartTwo = new float[halfLength];
        System.arraycopy(valuesForCalculation, 0, valuesPartOne, 0, halfLength);
        System.arraycopy(valuesForCalculation, halfLength, valuesPartTwo, 0, halfLength);

        Runnable taskFirstPartArray = () -> {
            for (int i = 0; i < halfLength; i++) {
                valuesFloatPartOne[i] = (float) (valuesPartOne[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
            }
        };
        Runnable taskSecondPartArray = () -> {
            for (int i = 0; i < halfLength; i++) {
                valuesFloatPartTwo[i] = (float) (valuesPartTwo[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
            }
        };
        Thread threadOne = new Thread(taskFirstPartArray);
        Thread threadTwo = new Thread(taskSecondPartArray);
        threadOne.start();
        threadTwo.start();
        try {
            threadOne.join();
            threadTwo.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // склейка массивов
        float[] valuesAfterCalculation = new float[mainArraylength];
        System.arraycopy(valuesFloatPartOne, 0, valuesAfterCalculation, 0, halfLength);
        System.arraycopy(valuesFloatPartTwo, 0, valuesAfterCalculation, halfLength, halfLength);

        //- Вычислить затраченное время от старта до завершения программы и вывод его в консоль
        long allTimeTask = System.currentTimeMillis() - startTimeTask;
        System.out.println("The programm was continue  " + allTimeTask + " millisec");
    }
}


