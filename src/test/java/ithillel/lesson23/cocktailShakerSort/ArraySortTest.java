package ithillel.lesson23.cocktailShakerSort;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullSource;

import java.util.stream.Stream;

class ArraySortTest {
    ArraySort arraySort = new ArraySort();

    @ParameterizedTest
    @MethodSource("arrayForSort")
    void shouldRetrieveSortedArray(int[] sortedArray, int[] arrayForSort) {
        Assertions.assertArrayEquals(sortedArray, arraySort.cocktailShakerSort(arrayForSort));
    }

    static Stream<Arguments> arrayForSort() {
        return Stream.of(
                Arguments.of(new int[]{}, new int[]{}),
                Arguments.of(new int[]{1, 1, 1}, new int[]{1, 1, 1}),
                Arguments.of(new int[]{-35, -9, 0, 4, 8, 17, 39}, new int[]{39, -9, 4, 0, -35, 17, 8}),
                Arguments.of(new int[]{16, 17, 18, 19, 20, 21, 22}, new int[]{22, 20, 21, 18, 17, 16, 19})
        );
    }

    @ParameterizedTest
    @NullSource
    void shouldThrowRuntimeExceptionIfArrayEqualsNull(int[] arrayIsNull) {
        Assertions.assertThrowsExactly(RuntimeException.class, () -> arraySort.cocktailShakerSort(arrayIsNull));
    }

    @ParameterizedTest
    @MethodSource("sourceAndTargetArrays")
    void shouldRetrieveResultOfMergingTwoArrays(int[] resultArray, int[] sourceArray, int[] targetArray) {
        Assertions.assertArrayEquals(resultArray, arraySort.arrayCopy(sourceArray, targetArray));
    }

    static Stream<Arguments> sourceAndTargetArrays() {
        return Stream.of(
                Arguments.of(new int[]{1, 2, 3, 4}, new int[]{4}, new int[]{1, 2, 3}),
                Arguments.of(new int[]{36, 37, 6, 5, 4, 3, 2, 1,}, new int[]{6, 5, 4, 3, 2, 1}, new int[]{36, 37}),
                Arguments.of(new int[]{1, 2, 3, 4, 5, 6, 7}, new int[]{6, 7}, new int[]{1, 2, 3, 4, 5}),
                Arguments.of(new int[]{1, 2, 3, 4, 5}, new int[]{1, 2, 3, 4, 5}, new int[]{})
        );
    }

    @ParameterizedTest
    @MethodSource("sourceAndTargetNullArrays")
    void shouldThrowRuntimeExceptionIfSourceOrTargetArrayEqualsNull(int[] sourceArray, int[] targetArray) {
        Assertions.assertThrowsExactly(RuntimeException.class, () -> arraySort.arrayCopy(sourceArray, targetArray));
    }

    static Stream<Arguments> sourceAndTargetNullArrays() {
        return Stream.of(
                Arguments.of(null, new int[]{1, 2, 3}),
                Arguments.of(new int[]{1, 2, 3}, null),
                Arguments.of(null, null)
        );
    }
}
