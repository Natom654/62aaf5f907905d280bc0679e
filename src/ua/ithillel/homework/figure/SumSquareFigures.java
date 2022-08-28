package ua.ithillel.homework.figure;

import java.lang.reflect.Array;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SumSquareFigures {
    public static void main(String[] args) {
        Circle c1 = new Circle(25);
        Triangle t1 = new Triangle(12.5, 10);
        Square s1 = new Square(21.5);
        Figure[] figures = new Figure[]{c1, t1, s1};

        System.out.printf("Square of all figures - " + "%.2f",sumsquare(figures));
    }

    public static double sumsquare(Figure[] figures) {
        double sum = 0;
        for (int i = 0; i < figures.length; i++) {
            sum = sum + figures[i].squarefigure();
        }
        return sum;
    }
}


