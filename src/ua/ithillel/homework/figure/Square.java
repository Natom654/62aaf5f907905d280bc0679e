package ua.ithillel.homework.figure;

public class Square implements Figure {
    double sidesquare;

    public Square(double sidesquare) {
        this.sidesquare = sidesquare;
    }

    @Override
    public double squarefigure() {
        return (sidesquare * 2);
    }
}
