package ua.ithillel.homework.figure;

import static java.lang.Math.PI;

public class Circle implements Figure {
    double radiuse;

    public Circle(double radiuse) {
        this.radiuse = radiuse;
    }

    @Override
    public double squarefigure() {
        return PI*radiuse*radiuse;
    }
}
