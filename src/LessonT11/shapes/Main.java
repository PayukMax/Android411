package LessonT11.shapes;

import LessonT11.test.Rect;

public class Main {
    public static void main(String[] args) {
//    Square square = new Square(3,"red");
//    square.info();
//    Rectangle rect = new Rectangle(7,3,"green");
//    rect.info();
//    Triangle tr = new Triangle(5,"yellow");
//    tr.info();

    Shape[] shapes = new Shape[3];
    shapes[0] = new Square(3,"red");
    shapes[1] = new Rectangle(7,3,"green");
    shapes[2] = new Triangle(5,"yellow");

        for (Shape s:shapes) {
            s.info();
        }


    }
}
