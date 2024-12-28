package LessonT11.tables;

public class RoundTable extends Table{
    public RoundTable(double radius) {
        super(radius);
    }

    @Override
    public void calcArea() {
        System.out.printf("Радиус: %.0f%nПлощадь: %.2f%n", getRadius(), Math.PI*Math.pow(getRadius(),2));
    }
}
