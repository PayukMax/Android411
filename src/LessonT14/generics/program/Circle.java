package LessonT14.generics.program;

public class Circle implements Figure{
    private double rad;

    public Circle(double rad) {
        this.rad = rad;
    }

    @Override
    public double getArea() {
        return Math.PI*rad*rad;
    }
}
