package LessonT9.square;

public class Main {
    public static void main(String[] args) {
        System.out.println("Площадь треугольника по формуле Герона (3,4,5): "+Square.triangle(3,4,5));
        System.out.println("Площадь треугольника через основание и высоту (6,7): "+Square.triangle(6,7));
        System.out.println("Площадь квадрата (7): "+Square.rectangle(7));
        System.out.println("Площадь прямоугольника (2,6): "+Square.rectangle(2,6));
        System.out.println("Количество подсчетов площади: "+Square.getCount());


    }
}
