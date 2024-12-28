package LessonT13.hw;

public class Main {
    public static void main(String[] args) {
        Figure[] mass = new Figure[3];
        mass[0] = new Ball("Шар", 4);
        mass[1] = new Cilindr("Цилиндр", 2, 2);
        mass[2] = new Pyramid("Пирамида",15,20);

        for (Figure f : mass)
            f.showData();

    }
}
