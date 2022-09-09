package ua.hillel.homework10;

public class ArrayValueCalculator {
    public static int doCalc(String[][] arraystring) throws ArrayCizeException, ArrayDataException {
        int sum = 0;

        if (arraystring.length != 4)
            throw new ArrayCizeException();

        for (int i = 0; i < arraystring.length; i++) {
            if (arraystring[i].length != 4)
                throw new ArrayCizeException();
            for (int j = 0; j < arraystring[i].length; j++) {
                try {
                    sum += Integer.parseInt(arraystring[i][j]);
                } catch (NumberFormatException e) {
                    throw new ArrayDataException(i, j);
                } catch (Exception e) {
                    throw new RuntimeException("Something went wrong during summing", e);
                }
            }
        } return sum;
    }
}
