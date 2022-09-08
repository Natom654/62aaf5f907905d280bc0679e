package ua.hillel.homework10;


import javax.print.AttributeException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.rmi.AccessException;
import java.sql.SQLException;

class MyException extends Exception {
    MyException(String message) {
        super(message);
    }
}

class ArrayDataException extends MyException {
    ArrayDataException(int row, int col) {
        super(String.format("Wrong data in  cell [%d, %d]\n", row, col));
    }
}

class ArrayCizeException extends MyException {
    ArrayCizeException() {
        super("It is not right size of Array");
    }
}

