package LessonT8.rect;

public class Main {
    public static void main(String[] args) {
        Rectangle rect1 = new Rectangle(4,15);
        rect1.setLength(3);
        rect1.setWidth(9);
        System.out.println("Длина прямоугольника: "+rect1.getLength());
        System.out.println("Ширина прямоугольника: "+rect1.getWidth());
        System.out.println("Площадь прямоугольника: "+rect1.getAres());
        System.out.println("Периемтр прямоугольника: "+rect1.getPerim());
        System.out.printf("Диагональ прямоугольника: %.2f%n%n",rect1.getGipotinuse());
        rect1.drowRect();

    }
}
