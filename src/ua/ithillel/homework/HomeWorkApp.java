package ua.ithillel.homework;

public class HomeWorkApp {
    public static void main(String[] args) {
        printThreeWords();
        checkSumSign();
        printColour(10);
        compareNumbers();
        System.out.println(checkNumbers(12, 3));
        printNegativeOrPositive(3);
        System.out.println(numberNegativeOrPositive(21));
        printLine("Hello, Java", 5);
        System.out.println(leapYear(2056));
    }

    // task2
    public static void printThreeWords() {
        String ThreeWords = "Orange\nBanana\nApple";
        System.out.println(ThreeWords);
    }

    // task3
    public static void checkSumSign() {
        int a = 10;
        int b = -15;
        int summ = a + b;
        if (summ > 0) {
            System.out.println("Summ is positive");
        } else {
            System.out.println("Summ is negative");
        }
    }

    // task4
    static void printColour(int value) {
        if (value < 0) {
            System.out.println("RED");
        } else if (value >= 0 && value <= 100) {
            System.out.println("YELLOW");
        } else if (value > 100) {
            System.out.println("GREEN");
        }
    }

    // task5
    static void compareNumbers() {
        int a = 125;
        int b = 356;
        if (a >= b) {
            System.out.println("a >= b");
        } else {
            System.out.println("a < b");
        }
    }

    // task6
    static boolean checkNumbers(int t, int s) {
        if ((t + s) >= 10 && (t + s) <= 20) {
            return true;
        } else {
            return false;
        }
    }

    // task 7
    static void printNegativeOrPositive(int g) {
        if (g >= 0) {
            System.out.println("Number is positive");
        } else {
            System.out.println("Number is negative");
        }
    }

    // task 8
    static boolean numberNegativeOrPositive(int f) {
        boolean numberNegativeOrPositive = f >= 0;
        return numberNegativeOrPositive;
    }

    // task 9
    public static void printLine(String text, int m) {
        for (m = 0; m < 5; m++) {
            System.out.println(text);
        }
    }

    // task 10
    static boolean leapYear(int year) {
        if (((year % 4 == 0) && year % 100 != 0) || (year % 400 == 0)) {
            return true;
        } else {
            return false;
        }
    }
}
