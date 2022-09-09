package ua.hillel.homework10;

public class Application {

    public static void main(String[] args) throws ArrayDataException, ArrayCizeException {

        String[][] arraystring = {
                {"1", "2", "3", "4"},
                {"5", "6", "7", "8",},
                {"9", "10", "11", "12"},
                {"13", "14", "15", "16"}
        };

        String[][] arraystring2 = {
                {"1", "2", "3", "4"},
                {"о", "6", "7", "8"},
                {"10", "11", "12", "13", "20"},
                {"14", "15", "16", "17"}
        };

        System.out.println(ArrayValueCalculator.doCalc(arraystring));
        System.out.println(ArrayValueCalculator.doCalc(arraystring2));
    }
}
