package LessonT14.generics.program;

public class Main {
    public static void main(String[] args) {
        Rectangle[] arr1 = new Rectangle[3];
        arr1[0] = new Rectangle(1,1);
        arr1[1] = new Rectangle(10,10);
        arr1[2] = new Rectangle(5,5);
        FigureStatistics<Rectangle> rs = new FigureStatistics<>(arr1);
        System.out.println("===== Прямоугольники \nСуммарная площадь: "+rs.getSumArea()+"\nМаксимальная площадь: "+rs.getMaxArea()+"\nМинимальная площадь: "+rs.getMinArea());


        Circle[] arr2 = new Circle[5];
        arr2[0] = new Circle(1);
        arr2[1] = new Circle(10);
        arr2[2] = new Circle(4);
        arr2[3] = new Circle(100);
        arr2[4] = new Circle(0.1);
        FigureStatistics<Circle> cs = new FigureStatistics<>(arr2);
        System.out.println("===== Круги \nСуммарная площадь: "+cs.getSumArea()+"\nМаксимальная площадь: "+cs.getMaxArea()+"\nМинимальная площадь: "+cs.getMinArea());



    }
}
