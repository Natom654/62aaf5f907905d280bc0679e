package ua.ithillel.array;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import ua.ithillel.SimpleMathLibrary;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class MethodForArrayContains14Test {
    @ParameterizedTest
    @NullAndEmptySource
    @MethodSource("valuesForArray")
    void shouldThrowRuntimeException_whenInvalidArrayPassed_asArgument(int[] values) {
        Assertions.assertThrowsExactly(
                RuntimeException.class,
                () -> MethodForArrayContains14.checkArrayTwoNumbers(values, 1, 4)
        );
    }

    private static Stream<Arguments> valuesForaArray() {
        return Stream.of(
                Arguments.arguments(new int[]{1, 4})
        );
    }
}