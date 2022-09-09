package ua.hillel.homework10;

import javax.print.AttributeException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.rmi.AccessException;
import java.sql.SQLException;

class ArrayCizeException extends RuntimeException {
    ArrayCizeException() {
        super("It is not right size of Array. Array should be 4*4 ");
    }
}

