package ua.ithillel;

import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SimpleMathLibraryTest {
    double firstNumber = 25;
    double secondNumber = 12;

    @Test
    public void summOfTwoNumber() {
        double sumnumbers = SimpleMathLibrary.add(firstNumber, secondNumber);
        Assertions.assertEquals(37, sumnumbers);
    }

    @Test
    public void minusOfTwoNumbers() {
        double minusNumbers = SimpleMathLibrary.minus(firstNumber, secondNumber);
        Assertions.assertEquals(13, minusNumbers);
    }
}