package ua.hillel.homework10;

class ArrayDataException extends RuntimeException {
    ArrayDataException(int row, int col) {
        super(String.format("Wrong data in  cell [%d, %d]\n", row, col));
    }
}
