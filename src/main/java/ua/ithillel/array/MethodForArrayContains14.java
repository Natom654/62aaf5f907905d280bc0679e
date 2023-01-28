package ua.ithillel.array;

public class MethodForArrayContains14 {
    public static boolean checkArrayTwoNumbers(int[] arrayForCheck, int value1, int value2) {
        boolean containsValue1 = false;
        boolean containsValue2 = false;

        for (int value : arrayForCheck) {
            if (value == value1)
                containsValue1 = true;
            else if (value == value2)
                containsValue2 = true;
            else
                return false;
        }
        return containsValue1 && containsValue2;
    }

}
