package LessonT13;

public class Base {
    public static void main(String[] args) {
        Shape[] geom = new Shape[3];
        geom[0] = new Line(5,"red",1,2,3,4);
        geom[1] = new Rectangle(2,"Yellow",5,10);
        geom[2] = new Triangle(3,"green",4,10);

        for (Shape g:geom) {
            g.draw();
            if (g instanceof MathShape) {
                double s = ((MathShape) g).getSquare(); // так вызвать не получится, поскольку не у всех экземпляро коллекции есть такой метод
                System.out.println("Площадь: "+s);
            }
        }

    }
}
