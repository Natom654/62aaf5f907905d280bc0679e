package ua.ithillel.array;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.NullSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class ArrayafterFourTest {

    @ParameterizedTest
    @NullAndEmptySource
    @MethodSource("invalidValuesProvider")
    void shouldThrowRuntimeException_whenInvalidArrayPassed_asArgument(int[] invalidValues) {
        Assertions.assertThrowsExactly(
                RuntimeException.class,
                () -> ArrayafterFour.subArrayAfterFour(invalidValues)
        );
    }

    private static Stream<Arguments> invalidValuesProvider() {
        return Stream.of(
                Arguments.arguments(new int[]{1})
        );
    }

    @ParameterizedTest
    @MethodSource("invalidValuesProvider")
    void shouldRetrieveSubArray_whenValidArrayPassedWithFourInside_asArgument(int[] param, int[] expected) {
        var actual = ArrayafterFour.subArrayAfterFour(param);
        Assertions.assertArrayEquals(expected, actual);
    }

    private static Stream<Arguments> validValuesProvider() {
        return Stream.of(
                Arguments.arguments(new int[]{4}, new int[0]),
                Arguments.arguments(new int[]{1, 4, 1}, new int[]{1}),
                Arguments.arguments(new int[]{1, 4, 1, 4, 1, 2}, new int[]{1, 2})
        );
    }
}