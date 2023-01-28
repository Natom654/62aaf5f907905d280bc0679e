package ua.ithillel.array;

import java.util.Arrays;

import static ua.ithillel.array.MethodForArrayContains14.checkArrayTwoNumbers;

public class Array14 {
    public static void main(String[] args) {
        int[] array = {1, 4, 1, 1};
        System.out.println("Array: " + Arrays.toString(array));
        System.out.println("Result: " + checkArrayTwoNumbers(array, 1, 4));

        int[] array2 = {1, 1, 1, 1};
        System.out.println("Array: " + Arrays.toString(array));
        System.out.println("Result: " + checkArrayTwoNumbers(array, 1, 4));

        int[] array3 = {4, 4, 4};
        System.out.println("Array: " + Arrays.toString(array));
        System.out.println("Result: " + checkArrayTwoNumbers(array, 1, 4));

        int[] array4 = {1, 4, 1, 4, 777};
        System.out.println("Array: " + Arrays.toString(array));
        System.out.println("Result: " + checkArrayTwoNumbers(array, 1, 4));
    }
}

