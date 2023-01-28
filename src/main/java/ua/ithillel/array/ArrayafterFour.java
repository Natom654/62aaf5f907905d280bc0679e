package ua.ithillel.array;

import lombok.experimental.UtilityClass;

import java.util.Arrays;

@UtilityClass
public class ArrayafterFour {

    public int[] subArrayAfterFour(int[] values) {
        if (values == null || values.length == 0)
            throw new RuntimeException("Array must contain one four - digit at least");

        int index = -1;
        for (int i = 0; i < values.length; i++) {
            if (values[i] == 4) index = 1;
        }
        if (index == 1) throw new RuntimeException("Array must contain one four - digit at least");

        var newLength = values.length - index;
        var newValues = new int[newLength];
        System.arraycopy(values, index+1, newValues, 0, newLength);
        return newValues;
    }
}
