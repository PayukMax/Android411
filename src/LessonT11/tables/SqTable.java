package LessonT11.tables;

public class SqTable extends Table{
    public SqTable(int width, int height) {
        super(width, height);
    }

    public SqTable(int width) {
        super(width);
    }

    @Override
    public void calcArea() {
        System.out.printf("Ширина: %d%nВысота: %d%nПлощадь: %d%n%n", getWidth(), getHeight(), getHeight()*getWidth());
    }
}
