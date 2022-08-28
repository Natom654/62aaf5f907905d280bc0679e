package ua.ithillel.homework.figure;

public class Triangle implements Figure {
    double basetriangle;
    double highttriangle;

    public Triangle(double basetriangle, double highttriangle) {
        this.basetriangle = basetriangle;
        this.highttriangle = highttriangle;
    }

    @Override
    public double squarefigure() {
        return (0.5 *basetriangle* highttriangle) ;
    }
}
