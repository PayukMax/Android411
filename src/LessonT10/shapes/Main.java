package LessonT10.shapes;

public class Main {
    public static void main(String[] args) {
Rectangle rect = new Rectangle(10,20,"Green");
        System.out.println("Ширина: "+rect.getWidth());
        System.out.println("Высота: "+rect.getHeight());
        System.out.println("Цвет: "+rect.getColor());
        System.out.println("Площадь: "+rect.area());


    }
}
